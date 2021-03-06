/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.esofthead.mycollab.vaadin.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

/**
 * @author MyCollab Ltd.
 * @since 4.5.4
 *
 */
public class RightSidebarLayout extends CssLayout {
	private static final long serialVersionUID = 6058720774092113093L;

	private final CssLayout contentWrap;
	private final CssLayout sidebarWrap;

	public RightSidebarLayout() {
		this.setStyleName("rightsidebar-layout");

		this.contentWrap = new CssLayout();
		this.contentWrap.setStyleName("content-wrap");
		this.contentWrap.setWidth("100%");
		this.addComponent(contentWrap);

		this.sidebarWrap = new CssLayout();
		this.sidebarWrap.setStyleName("sidebar-wrap");
		this.sidebarWrap.setWidth("250px");
		this.addComponent(sidebarWrap);
	}

	public void setContent(Component c) {
		this.contentWrap.removeAllComponents();
		this.contentWrap.addComponent(c);
	}

	public void setSidebar(Component c) {
		this.sidebarWrap.removeAllComponents();
		this.sidebarWrap.addComponent(c);
	}

}
