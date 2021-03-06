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
package com.esofthead.mycollab.module.project.view.standup;

import com.esofthead.mycollab.common.UrlTokenizer;
import com.esofthead.mycollab.core.arguments.DateSearchField;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.arguments.SearchField;
import com.esofthead.mycollab.eventmanager.EventBusFactory;
import com.esofthead.mycollab.module.project.domain.SimpleStandupReport;
import com.esofthead.mycollab.module.project.domain.criteria.StandupReportSearchCriteria;
import com.esofthead.mycollab.module.project.events.ProjectEvent;
import com.esofthead.mycollab.module.project.service.StandupReportService;
import com.esofthead.mycollab.module.project.view.ProjectUrlResolver;
import com.esofthead.mycollab.module.project.view.parameters.ProjectScreenData;
import com.esofthead.mycollab.module.project.view.parameters.StandupScreenData;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.PageActionChain;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
public class StandupUrlResolver extends ProjectUrlResolver {
	public StandupUrlResolver() {
		this.addSubResolver("list", new ListUrlResolver());
		this.addSubResolver("add", new PreviewUrlResolver());
	}

	private static FastDateFormat simpleDateFormat = FastDateFormat.getInstance("MM/dd/yyyy");

	/**
	 * 
	 * @param dateVal
	 * @return
	 */
	private static Date parseDate(String dateVal) {
		try {
			return simpleDateFormat.parse(dateVal);
		} catch (ParseException e) {
			return new GregorianCalendar().getTime();
		}
	}

	private static class ListUrlResolver extends ProjectUrlResolver {
		@Override
		protected void handlePage(String... params) {
			UrlTokenizer token = new UrlTokenizer(params[0]);
			int projectId = token.getInt();

			StandupReportSearchCriteria standupSearchCriteria = new StandupReportSearchCriteria();
			standupSearchCriteria
					.setProjectId(new NumberSearchField(projectId));

			if (token.hasMoreTokens()) {
				Date date = parseDate(token.getString());
				standupSearchCriteria.setOnDate(new DateSearchField(
						SearchField.AND, date));
			} else {
				standupSearchCriteria.setOnDate(new DateSearchField(
						SearchField.AND, new GregorianCalendar().getTime()));
			}

			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(projectId),
					new StandupScreenData.Search(standupSearchCriteria));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}
	}

	private static class PreviewUrlResolver extends ProjectUrlResolver {
		@Override
		protected void handlePage(String... params) {
			UrlTokenizer token = new UrlTokenizer(params[0]);

			int projectId = token.getInt();
			Date onDate = parseDate(token.getString());

			StandupReportService reportService = ApplicationContextUtil
					.getSpringBean(StandupReportService.class);
			SimpleStandupReport report = reportService
					.findStandupReportByDateUser(projectId,
							AppContext.getUsername(), onDate,
							AppContext.getAccountId());
			if (report == null) {
				report = new SimpleStandupReport();
			}

			PageActionChain chain = new PageActionChain(
					new ProjectScreenData.Goto(projectId),
					new StandupScreenData.Add(report));
			EventBusFactory.getInstance().post(
					new ProjectEvent.GotoMyProject(this, chain));
		}
	}
}
