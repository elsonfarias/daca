package dao;

import java.util.ArrayList;
import java.util.List;

import entities.ItemBiblioteca;
import filters.ItemBibliotecaFilter;
import service.ServiceDacException;

public class ItemBibliotecaInMemoryDAO extends DAO implements ItemBibliotecaDao {
	private static final long serialVersionUID = 1L;

	private InMemoryDB db = new InMemoryDB();

	@Override
	public void save(ItemBiblioteca obj) throws PersistenciaDacException {
		db.save(obj);
	}

	@Override
	public ItemBiblioteca update(ItemBiblioteca obj) throws PersistenciaDacException {
		return (ItemBiblioteca) db.update(obj);
	}

	@Override
	public void delete(ItemBiblioteca obj) throws PersistenciaDacException {
		db.delete(obj);
	}

	@Override
	public ItemBiblioteca getByID(Integer objId) throws PersistenciaDacException {
		return (ItemBiblioteca) db.getByID(objId).clone();
	}

	@Override
	public List<ItemBiblioteca> getAll() throws PersistenciaDacException {
		List<ItemBiblioteca> resultado = new ArrayList<>();
		for (ItemBiblioteca obj : db.getAll(ItemBiblioteca.class)) {
			resultado.add(obj.clone());
		}
		return resultado;
	}

	@Override
	public List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws PersistenciaDacException {
		List<ItemBiblioteca> allObjs = getAll();

		if (filter == null || filter.isEmpty()) {
			return allObjs;
		}

		List<ItemBiblioteca> resultado = new ArrayList<>();
		for (ItemBiblioteca item : allObjs) {

			// Título
			if (notEmpty(filter.getTitulo())) {
				if (!contains(item.getTitulo(), filter.getTitulo())) {
					continue;
				}
			}

			// Editora
			if (notEmpty(filter.getEditora())) {
				if (!contains(item.getEditora(), filter.getEditora())) {
					continue;
				}
			}

			// Data Publicação min
			if (notEmpty(filter.getDataPublicacaoMin())) {
				if (!assertDate(item.getDataPublicacao(), filter.getDataPublicacaoMin(), true)) {
					continue;
				}
			}

			// Data Publicação max
			if (notEmpty(filter.getDataPublicacaoMax())) {
				if (!assertDate(item.getDataPublicacao(), filter.getDataPublicacaoMax(), false)) {
					continue;
				}
			}

			// ISBN
			if (notEmpty(filter.getiSBN())) {
				if (!contains(item.getiSBN(), filter.getiSBN())) {
					continue;
				}
			}

			// Páginas min
			if (notEmpty(filter.getMinimoPaginas())) {
				if (item.getQuantidadePaginas() < filter.getMinimoPaginas()) {
					continue;
				}
			}

			// Páginas max
			if (notEmpty(filter.getMaximoPaginas())) {
				if (item.getQuantidadePaginas() > filter.getMaximoPaginas()) {
					continue;
				}
			}

			// Tipo
			if (notEmpty(filter.getTipo())) {
				if (!equals(filter.getTipo(), item.getTipo())) {
					continue;
				}
			}
			resultado.add(item);
		}
		return resultado;
	}

}
