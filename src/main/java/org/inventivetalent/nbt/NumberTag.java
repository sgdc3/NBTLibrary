package org.inventivetalent.nbt;

public abstract class NumberTag<V extends Number> extends NBTTag<V> {
	public NumberTag(String name) {
		super(name);
	}
}