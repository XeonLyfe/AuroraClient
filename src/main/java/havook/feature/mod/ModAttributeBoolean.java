/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature.mod;

public class ModAttributeBoolean extends ModAttribute {
	public boolean value;
	private final transient boolean nativeValue;

	public ModAttributeBoolean(String name, boolean nativeValue) {
		super(name);
		this.nativeValue = nativeValue;
		value = nativeValue;
	}

	public boolean getNativeValue() {
		return nativeValue;
	}
}
