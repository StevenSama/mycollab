/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.crm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ucd")
public class ContactCaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public ContactCaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    @SuppressWarnings("ucd")
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContactidIsNull() {
            addCriterion("contactId is null");
            return (Criteria) this;
        }

        public Criteria andContactidIsNotNull() {
            addCriterion("contactId is not null");
            return (Criteria) this;
        }

        public Criteria andContactidEqualTo(Integer value) {
            addCriterion("contactId =", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotEqualTo(Integer value) {
            addCriterion("contactId <>", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidGreaterThan(Integer value) {
            addCriterion("contactId >", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contactId >=", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidLessThan(Integer value) {
            addCriterion("contactId <", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidLessThanOrEqualTo(Integer value) {
            addCriterion("contactId <=", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidIn(List<Integer> values) {
            addCriterion("contactId in", values, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotIn(List<Integer> values) {
            addCriterion("contactId not in", values, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidBetween(Integer value1, Integer value2) {
            addCriterion("contactId between", value1, value2, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotBetween(Integer value1, Integer value2) {
            addCriterion("contactId not between", value1, value2, "contactid");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNull() {
            addCriterion("caseId is null");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNotNull() {
            addCriterion("caseId is not null");
            return (Criteria) this;
        }

        public Criteria andCaseidEqualTo(Integer value) {
            addCriterion("caseId =", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotEqualTo(Integer value) {
            addCriterion("caseId <>", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThan(Integer value) {
            addCriterion("caseId >", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("caseId >=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThan(Integer value) {
            addCriterion("caseId <", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThanOrEqualTo(Integer value) {
            addCriterion("caseId <=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidIn(List<Integer> values) {
            addCriterion("caseId in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotIn(List<Integer> values) {
            addCriterion("caseId not in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidBetween(Integer value1, Integer value2) {
            addCriterion("caseId between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("caseId not between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIsNull() {
            addCriterion("createdTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIsNotNull() {
            addCriterion("createdTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeEqualTo(Date value) {
            addCriterion("createdTime =", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotEqualTo(Date value) {
            addCriterion("createdTime <>", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeGreaterThan(Date value) {
            addCriterion("createdTime >", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createdTime >=", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeLessThan(Date value) {
            addCriterion("createdTime <", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeLessThanOrEqualTo(Date value) {
            addCriterion("createdTime <=", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIn(List<Date> values) {
            addCriterion("createdTime in", values, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotIn(List<Date> values) {
            addCriterion("createdTime not in", values, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeBetween(Date value1, Date value2) {
            addCriterion("createdTime between", value1, value2, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotBetween(Date value1, Date value2) {
            addCriterion("createdTime not between", value1, value2, "createdtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated do_not_delete_during_merge Mon May 18 10:06:55 ICT 2015
     */
    @SuppressWarnings("ucd")
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_crm_contacts_cases
     *
     * @mbggenerated Mon May 18 10:06:55 ICT 2015
     */
    @SuppressWarnings("ucd")
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}