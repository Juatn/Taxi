package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class ListaOrdenada<E> extends ArrayList<E> {

	protected Comparator<E> comp;

	public ListaOrdenada(Comparator<E> comp) {

		this.comp = comp;
	}

	@Override
	public boolean add(E element) {

		super.add(element);
		Collections.sort(this, comp);
		return true;

	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {

		super.addAll(collection);
		Collections.sort(this, comp);
		return true;

	}

}
