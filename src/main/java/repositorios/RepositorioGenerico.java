package repositorios;

import java.util.List;
import java.util.Optional;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

public abstract class RepositorioGenerico<E extends EntidadPersistente> implements WithGlobalEntityManager, TransactionalOps {
	
	public List<E> getAllInstances() {
		
		return entityManager()
				.createQuery("FROM " + getClase().getSimpleName(), getClase())
				.getResultList();
	}
	
	public Optional<E> getPorId(long id) {
		
		return Optional.ofNullable(entityManager().find(getClase(), id));
	}	
	
	public void agregar(E unElemento) {
		
		withTransaction(() -> entityManager().persist(unElemento));
	}
		
	public void borrar(E unElemento) {
		
		withTransaction(() -> entityManager().remove(unElemento));
	}
	
	protected abstract Class<E> getClase();
}