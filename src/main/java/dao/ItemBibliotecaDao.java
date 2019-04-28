package dao;

import java.util.List;

import entities.ItemBiblioteca;
import filters.ItemBibliotecaFilter;
import service.ServiceDacException;

public interface ItemBibliotecaDao {
	public void save(ItemBiblioteca obj) throws PersistenciaDacException;

	ItemBiblioteca update(ItemBiblioteca obj) throws PersistenciaDacException;

	public void delete(ItemBiblioteca obj) throws PersistenciaDacException;

	ItemBiblioteca getByID(Integer objId) throws PersistenciaDacException;

	List<ItemBiblioteca> getAll() throws PersistenciaDacException;

	List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws PersistenciaDacException;

	

}
