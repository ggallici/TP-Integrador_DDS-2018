package repositorios;

import java.util.Collection;
import java.util.HashSet;

public abstract class RepositorioGenerico<E extends EntidadPersistente> {

	protected Collection<E> elementos = new HashSet<>();
	
	public Collection<E> getAllInstances() {
		
		return elementos;
	}	
	
	public void agregar(E unElemento) {
		
		elementos.add(unElemento);
	}
		
	public void borrar(E unElemento) {
		
		elementos.remove(unElemento);
	}
}