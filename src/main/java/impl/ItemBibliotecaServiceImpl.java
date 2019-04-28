package impl;

import java.io.Serializable;
import java.util.List;

import dao.ItemBibliotecaDao;
import dao.ItemBibliotecaInMemoryDAO;
import dao.PersistenciaDacException;
import entities.ItemBiblioteca;
import filters.ItemBibliotecaFilter;
import service.ItemBibliotecaService;
import service.ServiceDacException;

public class ItemBibliotecaServiceImpl implements Serializable, ItemBibliotecaService {
	private static final long serialVersionUID = -7803325791425670859L;
	private ItemBibliotecaDao itemDAO = new ItemBibliotecaInMemoryDAO();

	@Override
	public void save(ItemBiblioteca item) throws ServiceDacException {
		try {

			// user.limparCamposEspecificos();
			// calcularHashDaSenha(user);
			itemDAO.save(item);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public void update(ItemBiblioteca item) throws ServiceDacException {
		try {

			itemDAO.update(item);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(ItemBiblioteca item) throws ServiceDacException {
		try {
			itemDAO.delete(item);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public ItemBiblioteca getByID(int itemId) throws ServiceDacException {
		try {
			return itemDAO.getByID(itemId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public List<ItemBiblioteca> getAll() throws ServiceDacException {
		try {
			return itemDAO.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws ServiceDacException {
		try {
			filter.validate();
			return itemDAO.findBy(filter);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

}
