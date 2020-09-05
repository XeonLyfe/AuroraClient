/*******************************************************************************
 * Copyright © 2019 | Crimz8n (Rafal Zelazko) | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ******************************************************************************/

package havook.feature;

public abstract class Command {
	public String name = "";
	public String syntax = "";
	public String description = "";

	public Command(String name, String syntax, String description) {
		this.name = name;
		this.syntax = syntax;
		this.description = description;
	}

	public abstract void execute(String[] args);
}
