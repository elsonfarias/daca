package service;

import java.util.List;

import entities.ItemBiblioteca;
import filters.ItemBibliotecaFilter;

public interface ItemBibliotecaService {

	public void save(ItemBiblioteca item) throws ServiceDacException;

	public void update(ItemBiblioteca item) throws ServiceDacException;

	public void delete(ItemBiblioteca item) throws ServiceDacException;

	ItemBiblioteca getByID(int itemId) throws ServiceDacException;

	List<ItemBiblioteca> getAll() throws ServiceDacException;

	List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws ServiceDacException;

}
