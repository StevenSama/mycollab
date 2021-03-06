/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.mobile.module.project.view;

import com.esofthead.mycollab.common.GenericLinkUtils;
import com.esofthead.mycollab.common.ModuleNameConstants;
import com.esofthead.mycollab.common.domain.criteria.ActivityStreamSearchCriteria;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.arguments.SearchField;
import com.esofthead.mycollab.core.arguments.SetSearchField;
import com.esofthead.mycollab.mobile.module.project.CurrentProjectVariables;
import com.esofthead.mycollab.mobile.module.project.ui.InsideProjectNavigationMenu;
import com.esofthead.mycollab.mobile.ui.AbstractListPresenter;
import com.esofthead.mycollab.module.project.ProjectRolePermissionCollections;
import com.esofthead.mycollab.module.project.domain.ProjectActivityStream;
import com.esofthead.mycollab.module.project.i18n.ProjectCommonI18nEnum;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.ScreenData;
import com.esofthead.mycollab.vaadin.ui.NotificationUtil;
import com.esofthead.vaadin.mobilecomponent.MobileNavigationManager;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

/**
 * @author MyCollab Ltd.
 *
 * @since 4.5.2
 */
public class ProjectActivityStreamPresenter extends
        AbstractListPresenter<ProjectActivityView, ActivityStreamSearchCriteria, ProjectActivityStream> {
    private static final long serialVersionUID = -2089284900326846089L;

    public ProjectActivityStreamPresenter() {
        super(ProjectActivityView.class);
    }

    @Override
    protected void onGo(ComponentContainer navigator, ScreenData<?> data) {
        if (CurrentProjectVariables
                .canRead(ProjectRolePermissionCollections.PROJECT)) {
            InsideProjectNavigationMenu projectModuleMenu = (InsideProjectNavigationMenu) ((MobileNavigationManager) UI
                    .getCurrent().getContent()).getNavigationMenu();
            projectModuleMenu
                    .selectButton(AppContext
                            .getMessage(ProjectCommonI18nEnum.M_VIEW_PROJECT_ACTIVITIES));
            super.onGo(navigator, data);
            ActivityStreamSearchCriteria searchCriteria = new ActivityStreamSearchCriteria();
            searchCriteria.setModuleSet(new SetSearchField<>(
                    SearchField.AND, new String[]{ModuleNameConstants.PRJ}));
            searchCriteria.setSaccountid(new NumberSearchField(AppContext
                    .getAccountId()));

            searchCriteria.setExtraTypeIds(new SetSearchField<>(
                    CurrentProjectVariables.getProjectId()));
            doSearch(searchCriteria);
            AppContext.addFragment("project/activities/"
                            + GenericLinkUtils.encodeParam(CurrentProjectVariables.getProjectId()),
                    AppContext.getMessage(ProjectCommonI18nEnum.M_VIEW_PROJECT_ACTIVITIES));
        } else {
            NotificationUtil.showMessagePermissionAlert();
        }
    }

}
