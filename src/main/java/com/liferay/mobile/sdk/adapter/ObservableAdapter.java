/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.sdk.adapter;

import com.liferay.mobile.sdk.Call;

import rx.Observable;

/**
 * @author Bruno Farache
 */
public class ObservableAdapter<T> implements ReturnTypeAdapter<T, Observable> {

	@Override
	public Observable<T> adapt(Call<T> call) {
		CallOnSubscribe<T> subscribe = new CallOnSubscribe<>();
		CallObservable<T> observable = new CallObservable<>(subscribe, call);

		subscribe.observable(observable);

		return observable;
	}

	@Override
	public Class<Observable> type() {
		return Observable.class;
	}

}