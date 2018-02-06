/*
 *
 */
package com.api.beans;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ListParameterizedType  implements ParameterizedType{

	private Type type;

	public ListParameterizedType(Type type) {
		this.type = type;
	}

	@Override
	public Type[] getActualTypeArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getRawType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getOwnerType() {
		// TODO Auto-generated method stub
		return null;
	}

}
