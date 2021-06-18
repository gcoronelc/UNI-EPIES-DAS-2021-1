package pe.sistventaventas.service;

import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public interface ICrud<T> {

	/**
	 * Retorn todos los registros de la tabla.
	 * @return Retorna una lista con todos los registros de la tabla.
	 */
	List<T> leerTodos();
	
	/**
	 * Permite realizar una consulta en base a un filtro.
	 * @param bean Parameros para construir el filtro.
	 * @return Retorna los registros que cumple con el filtro.
	 */
	List<T> leerTodos(T bean);
	
	/**
	 * Permite leer un registro específico
	 * @param id Código del registro.
	 * @return Retorna u objeto con los datos del registro.
	 */
	List<T> leerPorId(int id);
	
	/**
	 * Pemite registrar nuevos registros en la tabla correspondiente.
	 * @param bean Datos del nuevo objeto.
	 * @return Retorna el codigo del nuevo objeto.
	 */
	int grabar(T bean);
	
	/**
	 * Pemite actualizar los datos de un registro.
	 * @param bean Datos del registro a actualizar.
	 * @return Retorna el codigo del registro actualizado.
	 */
	int actualizar(T bean);
	
	/**
	 * Pemite eliminar un registro e la tabla, siempre que sea posible.
	 * @param id El ID del registro a eliminar.
	 * @return Retorna el codigo del registro eliminado.
	 */
	int eliminar(int id);
	
}
