package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements ILista <T>{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable [max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void addFirst(T elemento)
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}

		T [] anterior = elementos;
		elementos = (T[]) new Comparable [tamanoMax];
		elementos[0] = elemento;
		for ( int i = 0; i < tamanoAct; i++)
		{
			elementos[i+1] = anterior[i];
		} 
		tamanoAct++;
	}

	public void addLast(T elemento)
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = elemento;
		tamanoAct++;
	}

	public void insertElement(T element, int pos)
	{
		int posArreglo = pos-1;
		
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Comparable [tamanoMax];
			for ( int i = 0; i < size(); i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}

		T [] anterior = elementos;
		elementos = (T[]) new Comparable [tamanoMax];
		
		for ( int i = 0; i < posArreglo; i++)
		{
			elementos[i] = anterior[i];
		}
		
		elementos[posArreglo] = element;
		
		for ( int j = posArreglo; j < size(); j++)
		{
			elementos[j+1] = anterior[j];
		}
		
		tamanoAct++;
		
	}

	public T removeFirst( )
	{
		T eliminado = elementos [0];
		if (size() > 1)
		{
			for (int i = 0; i < size() - 1; i++)
			{
				elementos [i] = elementos [i+1];
				tamanoAct--;
			}
			return eliminado;
		}
		else if(size()==1)
		{
			elementos [0] = null;
			tamanoAct--;
			return eliminado;
		}
		else 
		{
			return null;
		}
	}

	public T removeLast( ) 
	{
		if (size()>0)
		{
			T eliminado = elementos [tamanoAct -1];
			elementos [tamanoAct -1] = null;
			tamanoAct --;
			return eliminado;
		}
		else 
		{
			return null;
		}
	}

	public T deleteElement( int pos) 
	{
		int posArreglo = pos-1;
		T [] anterior = elementos;
		elementos = (T[]) new Comparable [tamanoMax];
		
		for ( int i = 0; i < posArreglo; i++)
		{
			elementos[i] = anterior[i];
		}
		
		T eliminado = anterior [posArreglo];
		for ( int j = posArreglo; j < size(); j++)
		{
			elementos[j] = anterior[j+1];
		}
		
		tamanoAct--;
		return eliminado;
	}

	public T firstElement( )
	{
		return elementos [0];
	}

	public T lastElement()
	{
		return elementos [tamanoAct-1];
	}

	public T getElement( int pos) 
	{
		if(size() > 0)
		{
			int posArreglo = pos-1;
			return elementos [posArreglo];
		}
		else
		{
			return null;
		}
	}

	public int size( ) 
	{
		return tamanoAct;
	}

	public boolean isEmpty( ) 
	{
		return tamanoAct == 0 ? true: false;
	}

	public int isPresent (T element)
	{
		int posicion = -1;
		if(size() > 0)
		{
			boolean encontro = false;
			for (int i = 0; i < size() && encontro == false; i++)
			{
				if (elementos[i].compareTo(element) == 0)
				{
					posicion = i + 1;
					encontro = true;
				}
			}
		}
		return posicion;
	}

	public void exchange (int pos1, int pos2)
	{
		if (pos1 <= size() && pos2 <= size())
		{
			T info1 = getElement(pos1);
			T info2 = getElement(pos2);

			changeInfo(pos1, info2);
			changeInfo(pos2, info1);
		}
	}

	public void changeInfo (int pos, T elem) 
	{
		int posArreglo = pos-1;
		elementos [posArreglo] = elem;
	}
}
