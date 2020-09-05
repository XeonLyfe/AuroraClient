/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod;

public class ModAttributeDouble extends ModAttribute {
	public double value;
	private final transient double nativeValue;

	public ModAttributeDouble(String name, double nativeValue) {
		super(name);
		this.nativeValue = nativeValue;
		value = nativeValue;
	}

	public double getNativeValue() {
		return nativeValue;
	}
}
