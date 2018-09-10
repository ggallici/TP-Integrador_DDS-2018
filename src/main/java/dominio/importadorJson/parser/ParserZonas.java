package dominio.importadorJson.parser;

import com.google.gson.Gson;

import dominio.Zona;

public class ParserZonas extends ParserJson<Zona> {

	private Gson parser = new Gson();
	
	@Override
	protected Gson getGsonParser() {
		
		return parser;
	}

	@Override
	protected Class<Zona> getParserClass() {
		
		return Zona.class;
	}
}