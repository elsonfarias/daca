package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import entities.Identificavel;

public class InMemoryDB {
	private static Map<Integer, Identificavel> REPOSITORY = new ConcurrentHashMap<>(new HashMap<>());

	private static AtomicInteger ID = new AtomicInteger();

	public void save(Identificavel obj) {
		obj.setId(ID.getAndIncrement());
		REPOSITORY.put(obj.getId(), obj);
	}

	public Identificavel update(Identificavel obj) {
		REPOSITORY.put(obj.getId(), obj);
		return obj;
	}

	public void delete(Identificavel obj) {
		REPOSITORY.remove(obj.getId());
	}

	@SuppressWarnings("unchecked")
	public <T extends Identificavel> T getByID(Integer objId) {
		Identificavel obj = REPOSITORY.get(objId);
		return obj != null ? (T) obj : null;
	}

	@SuppressWarnings("unchecked")
	public <T extends Identificavel> List<T> getAll(Class<T> clazz) {
		List<T> resultado = new ArrayList<>();
		for (Identificavel obj : REPOSITORY.values()) {
			if (clazz.isInstance(obj)) {
				resultado.add((T) obj);
			}
		}
		return resultado;
	}
}
