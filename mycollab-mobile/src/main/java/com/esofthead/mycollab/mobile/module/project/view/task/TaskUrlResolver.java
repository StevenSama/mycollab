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
package com.esofthead.mycollab.mobile.module.project.view.task;

import com.esofthead.mycollab.common.UrlTokenizer;
import com.esofthead.mycollab.core.MyCollabException;
import com.esofthead.mycollab.core.ResourceNotFoundException;
import com.esofthead.mycollab.eventmanager.EventBusFactory;
import com.esofthead.mycollab.mobile.module.project.ProjectUrlResolver;
import com.esofthead.mycollab.mobile.module.project.events.ProjectEvent;
import com.esofthead.mycollab.mobile.module.project.view.parameters.ProjectScreenData;
import com.esofthead.mycollab.mobile.module.project.view.parameters.TaskScreenData;
import com.esofthead.mycollab.module.project.ProjectLinkParams;
import com.esofthead.mycollab.module.project.domain.SimpleTask;
import com.esofthead.mycollab.module.project.service.ProjectTaskService;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.PageActionChain;

/**
 * @author MyCollab Ltd.
 *
 * @since 4.5.0
 *
 */
public class TaskUrlResolver extends ProjectUrlResolver {

	public TaskUrlResolver() {
		this.addSubResolver("list", new ListUrlResolver());
		this.addSubResolver("preview", new ReadUrlResolver());
		this.addSubResolver("edit", new EditUrlResolver());
		this.addSubResolver("add", new AddUrlResolver());
	}

	private static class ListUrlResolver extends ProjectUrlResolver {

		@Override
		protected void handlePage(String... params) {
			UrlTokenizer token = new UrlTokenizer(params[0]);

			int projectId = token.getInt();
			int listId = token.getInt();

			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(projectId),
					new TaskScreenData.List(listId));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}
	}

	private static class ReadUrlResolver extends ProjectUrlResolver {

		@Override
		protected void handlePage(String... params) {
			int projectId, taskId;

			if (ProjectLinkParams.isValidParam(params[0])) {
				String prjShortName = ProjectLinkParams
						.getProjectShortName(params[0]);
				int itemKey = ProjectLinkParams.getItemKey(params[0]);
				ProjectTaskService taskService = ApplicationContextUtil
						.getSpringBean(ProjectTaskService.class);
				SimpleTask task = taskService.findByProjectAndTaskKey(itemKey,
						prjShortName, AppContext.getAccountId());

				if (task != null) {
					projectId = task.getProjectid();
					taskId = task.getId();
				} else {
					throw new ResourceNotFoundException(
							"Can not find task with itemKey " + itemKey
									+ " and project " + prjShortName);
				}
			} else {
				UrlTokenizer tokenizer = new UrlTokenizer(params[0]);
				projectId = tokenizer.getInt();
				taskId = tokenizer.getInt();
			}

			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(projectId),
					new TaskScreenData.Read(taskId));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}

	}

	private static class EditUrlResolver extends ProjectUrlResolver {

		@Override
		protected void handlePage(String... params) {
			SimpleTask task;
			ProjectTaskService taskService = ApplicationContextUtil
					.getSpringBean(ProjectTaskService.class);

			if (ProjectLinkParams.isValidParam(params[0])) {
				String prjShortName = ProjectLinkParams
						.getProjectShortName(params[0]);
				int itemKey = ProjectLinkParams.getItemKey(params[0]);

				task = taskService.findByProjectAndTaskKey(itemKey,
						prjShortName, AppContext.getAccountId());
			} else {
				throw new MyCollabException("Can not find task link "
						+ params[0]);
			}

			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(task.getProjectid()),
					new TaskScreenData.Edit(task));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}
	}

	private static class AddUrlResolver extends ProjectUrlResolver {
		@Override
		protected void handlePage(String... params) {
			UrlTokenizer token = new UrlTokenizer(params[0]);

			int projectId = token.getInt();
			int taskListId = token.getInt();
			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(projectId),
					new TaskScreenData.Add(taskListId));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}
	}
}
