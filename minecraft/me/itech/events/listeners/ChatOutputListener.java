/*
 * Copyright � 2014 - 2016 | Wurst-Imperium | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package me.itech.events.listeners;

import me.itech.events.ChatOutputEvent;


public interface ChatOutputListener extends Listener
{
	public void onSentMessage(ChatOutputEvent event);
}
