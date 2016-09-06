package com.ssm.project.model;

import java.util.ArrayList;
import java.util.List;

public class VacationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VacationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(String value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(String value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(String value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(String value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(String value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(String value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLike(String value) {
            addCriterion("v_id like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotLike(String value) {
            addCriterion("v_id not like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<String> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<String> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(String value1, String value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(String value1, String value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVNameIsNull() {
            addCriterion("v_name is null");
            return (Criteria) this;
        }

        public Criteria andVNameIsNotNull() {
            addCriterion("v_name is not null");
            return (Criteria) this;
        }

        public Criteria andVNameEqualTo(String value) {
            addCriterion("v_name =", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotEqualTo(String value) {
            addCriterion("v_name <>", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThan(String value) {
            addCriterion("v_name >", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThanOrEqualTo(String value) {
            addCriterion("v_name >=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThan(String value) {
            addCriterion("v_name <", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThanOrEqualTo(String value) {
            addCriterion("v_name <=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLike(String value) {
            addCriterion("v_name like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotLike(String value) {
            addCriterion("v_name not like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameIn(List<String> values) {
            addCriterion("v_name in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotIn(List<String> values) {
            addCriterion("v_name not in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameBetween(String value1, String value2) {
            addCriterion("v_name between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotBetween(String value1, String value2) {
            addCriterion("v_name not between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVStarttimeIsNull() {
            addCriterion("v_starttime is null");
            return (Criteria) this;
        }

        public Criteria andVStarttimeIsNotNull() {
            addCriterion("v_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andVStarttimeEqualTo(String value) {
            addCriterion("v_starttime =", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeNotEqualTo(String value) {
            addCriterion("v_starttime <>", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeGreaterThan(String value) {
            addCriterion("v_starttime >", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("v_starttime >=", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeLessThan(String value) {
            addCriterion("v_starttime <", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeLessThanOrEqualTo(String value) {
            addCriterion("v_starttime <=", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeLike(String value) {
            addCriterion("v_starttime like", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeNotLike(String value) {
            addCriterion("v_starttime not like", value, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeIn(List<String> values) {
            addCriterion("v_starttime in", values, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeNotIn(List<String> values) {
            addCriterion("v_starttime not in", values, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeBetween(String value1, String value2) {
            addCriterion("v_starttime between", value1, value2, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVStarttimeNotBetween(String value1, String value2) {
            addCriterion("v_starttime not between", value1, value2, "vStarttime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeIsNull() {
            addCriterion("v_endtime is null");
            return (Criteria) this;
        }

        public Criteria andVEndtimeIsNotNull() {
            addCriterion("v_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andVEndtimeEqualTo(String value) {
            addCriterion("v_endtime =", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeNotEqualTo(String value) {
            addCriterion("v_endtime <>", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeGreaterThan(String value) {
            addCriterion("v_endtime >", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("v_endtime >=", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeLessThan(String value) {
            addCriterion("v_endtime <", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeLessThanOrEqualTo(String value) {
            addCriterion("v_endtime <=", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeLike(String value) {
            addCriterion("v_endtime like", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeNotLike(String value) {
            addCriterion("v_endtime not like", value, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeIn(List<String> values) {
            addCriterion("v_endtime in", values, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeNotIn(List<String> values) {
            addCriterion("v_endtime not in", values, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeBetween(String value1, String value2) {
            addCriterion("v_endtime between", value1, value2, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVEndtimeNotBetween(String value1, String value2) {
            addCriterion("v_endtime not between", value1, value2, "vEndtime");
            return (Criteria) this;
        }

        public Criteria andVDaysIsNull() {
            addCriterion("v_days is null");
            return (Criteria) this;
        }

        public Criteria andVDaysIsNotNull() {
            addCriterion("v_days is not null");
            return (Criteria) this;
        }

        public Criteria andVDaysEqualTo(String value) {
            addCriterion("v_days =", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysNotEqualTo(String value) {
            addCriterion("v_days <>", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysGreaterThan(String value) {
            addCriterion("v_days >", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysGreaterThanOrEqualTo(String value) {
            addCriterion("v_days >=", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysLessThan(String value) {
            addCriterion("v_days <", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysLessThanOrEqualTo(String value) {
            addCriterion("v_days <=", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysLike(String value) {
            addCriterion("v_days like", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysNotLike(String value) {
            addCriterion("v_days not like", value, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysIn(List<String> values) {
            addCriterion("v_days in", values, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysNotIn(List<String> values) {
            addCriterion("v_days not in", values, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysBetween(String value1, String value2) {
            addCriterion("v_days between", value1, value2, "vDays");
            return (Criteria) this;
        }

        public Criteria andVDaysNotBetween(String value1, String value2) {
            addCriterion("v_days not between", value1, value2, "vDays");
            return (Criteria) this;
        }

        public Criteria andVReasonIsNull() {
            addCriterion("v_reason is null");
            return (Criteria) this;
        }

        public Criteria andVReasonIsNotNull() {
            addCriterion("v_reason is not null");
            return (Criteria) this;
        }

        public Criteria andVReasonEqualTo(String value) {
            addCriterion("v_reason =", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonNotEqualTo(String value) {
            addCriterion("v_reason <>", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonGreaterThan(String value) {
            addCriterion("v_reason >", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonGreaterThanOrEqualTo(String value) {
            addCriterion("v_reason >=", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonLessThan(String value) {
            addCriterion("v_reason <", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonLessThanOrEqualTo(String value) {
            addCriterion("v_reason <=", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonLike(String value) {
            addCriterion("v_reason like", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonNotLike(String value) {
            addCriterion("v_reason not like", value, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonIn(List<String> values) {
            addCriterion("v_reason in", values, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonNotIn(List<String> values) {
            addCriterion("v_reason not in", values, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonBetween(String value1, String value2) {
            addCriterion("v_reason between", value1, value2, "vReason");
            return (Criteria) this;
        }

        public Criteria andVReasonNotBetween(String value1, String value2) {
            addCriterion("v_reason not between", value1, value2, "vReason");
            return (Criteria) this;
        }

        public Criteria andVCheckerIsNull() {
            addCriterion("v_checker is null");
            return (Criteria) this;
        }

        public Criteria andVCheckerIsNotNull() {
            addCriterion("v_checker is not null");
            return (Criteria) this;
        }

        public Criteria andVCheckerEqualTo(String value) {
            addCriterion("v_checker =", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerNotEqualTo(String value) {
            addCriterion("v_checker <>", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerGreaterThan(String value) {
            addCriterion("v_checker >", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerGreaterThanOrEqualTo(String value) {
            addCriterion("v_checker >=", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerLessThan(String value) {
            addCriterion("v_checker <", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerLessThanOrEqualTo(String value) {
            addCriterion("v_checker <=", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerLike(String value) {
            addCriterion("v_checker like", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerNotLike(String value) {
            addCriterion("v_checker not like", value, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerIn(List<String> values) {
            addCriterion("v_checker in", values, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerNotIn(List<String> values) {
            addCriterion("v_checker not in", values, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerBetween(String value1, String value2) {
            addCriterion("v_checker between", value1, value2, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVCheckerNotBetween(String value1, String value2) {
            addCriterion("v_checker not between", value1, value2, "vChecker");
            return (Criteria) this;
        }

        public Criteria andVStateIsNull() {
            addCriterion("v_state is null");
            return (Criteria) this;
        }

        public Criteria andVStateIsNotNull() {
            addCriterion("v_state is not null");
            return (Criteria) this;
        }

        public Criteria andVStateEqualTo(Integer value) {
            addCriterion("v_state =", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateNotEqualTo(Integer value) {
            addCriterion("v_state <>", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateGreaterThan(Integer value) {
            addCriterion("v_state >", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_state >=", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateLessThan(Integer value) {
            addCriterion("v_state <", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateLessThanOrEqualTo(Integer value) {
            addCriterion("v_state <=", value, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateIn(List<Integer> values) {
            addCriterion("v_state in", values, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateNotIn(List<Integer> values) {
            addCriterion("v_state not in", values, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateBetween(Integer value1, Integer value2) {
            addCriterion("v_state between", value1, value2, "vState");
            return (Criteria) this;
        }

        public Criteria andVStateNotBetween(Integer value1, Integer value2) {
            addCriterion("v_state not between", value1, value2, "vState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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