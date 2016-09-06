package com.ssm.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailExample() {
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(String value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(String value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(String value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(String value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(String value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(String value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLike(String value) {
            addCriterion("e_id like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotLike(String value) {
            addCriterion("e_id not like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<String> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<String> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(String value1, String value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(String value1, String value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andETitleIsNull() {
            addCriterion("e_title is null");
            return (Criteria) this;
        }

        public Criteria andETitleIsNotNull() {
            addCriterion("e_title is not null");
            return (Criteria) this;
        }

        public Criteria andETitleEqualTo(String value) {
            addCriterion("e_title =", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleNotEqualTo(String value) {
            addCriterion("e_title <>", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleGreaterThan(String value) {
            addCriterion("e_title >", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleGreaterThanOrEqualTo(String value) {
            addCriterion("e_title >=", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleLessThan(String value) {
            addCriterion("e_title <", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleLessThanOrEqualTo(String value) {
            addCriterion("e_title <=", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleLike(String value) {
            addCriterion("e_title like", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleNotLike(String value) {
            addCriterion("e_title not like", value, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleIn(List<String> values) {
            addCriterion("e_title in", values, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleNotIn(List<String> values) {
            addCriterion("e_title not in", values, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleBetween(String value1, String value2) {
            addCriterion("e_title between", value1, value2, "eTitle");
            return (Criteria) this;
        }

        public Criteria andETitleNotBetween(String value1, String value2) {
            addCriterion("e_title not between", value1, value2, "eTitle");
            return (Criteria) this;
        }

        public Criteria andEReceiveIsNull() {
            addCriterion("e_receive is null");
            return (Criteria) this;
        }

        public Criteria andEReceiveIsNotNull() {
            addCriterion("e_receive is not null");
            return (Criteria) this;
        }

        public Criteria andEReceiveEqualTo(String value) {
            addCriterion("e_receive =", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotEqualTo(String value) {
            addCriterion("e_receive <>", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveGreaterThan(String value) {
            addCriterion("e_receive >", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveGreaterThanOrEqualTo(String value) {
            addCriterion("e_receive >=", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveLessThan(String value) {
            addCriterion("e_receive <", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveLessThanOrEqualTo(String value) {
            addCriterion("e_receive <=", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveLike(String value) {
            addCriterion("e_receive like", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotLike(String value) {
            addCriterion("e_receive not like", value, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveIn(List<String> values) {
            addCriterion("e_receive in", values, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotIn(List<String> values) {
            addCriterion("e_receive not in", values, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveBetween(String value1, String value2) {
            addCriterion("e_receive between", value1, value2, "eReceive");
            return (Criteria) this;
        }

        public Criteria andEReceiveNotBetween(String value1, String value2) {
            addCriterion("e_receive not between", value1, value2, "eReceive");
            return (Criteria) this;
        }

        public Criteria andESenderIsNull() {
            addCriterion("e_sender is null");
            return (Criteria) this;
        }

        public Criteria andESenderIsNotNull() {
            addCriterion("e_sender is not null");
            return (Criteria) this;
        }

        public Criteria andESenderEqualTo(String value) {
            addCriterion("e_sender =", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderNotEqualTo(String value) {
            addCriterion("e_sender <>", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderGreaterThan(String value) {
            addCriterion("e_sender >", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderGreaterThanOrEqualTo(String value) {
            addCriterion("e_sender >=", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderLessThan(String value) {
            addCriterion("e_sender <", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderLessThanOrEqualTo(String value) {
            addCriterion("e_sender <=", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderLike(String value) {
            addCriterion("e_sender like", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderNotLike(String value) {
            addCriterion("e_sender not like", value, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderIn(List<String> values) {
            addCriterion("e_sender in", values, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderNotIn(List<String> values) {
            addCriterion("e_sender not in", values, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderBetween(String value1, String value2) {
            addCriterion("e_sender between", value1, value2, "eSender");
            return (Criteria) this;
        }

        public Criteria andESenderNotBetween(String value1, String value2) {
            addCriterion("e_sender not between", value1, value2, "eSender");
            return (Criteria) this;
        }

        public Criteria andEIsreadIsNull() {
            addCriterion("e_isread is null");
            return (Criteria) this;
        }

        public Criteria andEIsreadIsNotNull() {
            addCriterion("e_isread is not null");
            return (Criteria) this;
        }

        public Criteria andEIsreadEqualTo(Integer value) {
            addCriterion("e_isread =", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadNotEqualTo(Integer value) {
            addCriterion("e_isread <>", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadGreaterThan(Integer value) {
            addCriterion("e_isread >", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_isread >=", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadLessThan(Integer value) {
            addCriterion("e_isread <", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadLessThanOrEqualTo(Integer value) {
            addCriterion("e_isread <=", value, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadIn(List<Integer> values) {
            addCriterion("e_isread in", values, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadNotIn(List<Integer> values) {
            addCriterion("e_isread not in", values, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadBetween(Integer value1, Integer value2) {
            addCriterion("e_isread between", value1, value2, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsreadNotBetween(Integer value1, Integer value2) {
            addCriterion("e_isread not between", value1, value2, "eIsread");
            return (Criteria) this;
        }

        public Criteria andEIsdelIsNull() {
            addCriterion("e_isdel is null");
            return (Criteria) this;
        }

        public Criteria andEIsdelIsNotNull() {
            addCriterion("e_isdel is not null");
            return (Criteria) this;
        }

        public Criteria andEIsdelEqualTo(Integer value) {
            addCriterion("e_isdel =", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelNotEqualTo(Integer value) {
            addCriterion("e_isdel <>", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelGreaterThan(Integer value) {
            addCriterion("e_isdel >", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_isdel >=", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelLessThan(Integer value) {
            addCriterion("e_isdel <", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("e_isdel <=", value, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelIn(List<Integer> values) {
            addCriterion("e_isdel in", values, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelNotIn(List<Integer> values) {
            addCriterion("e_isdel not in", values, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelBetween(Integer value1, Integer value2) {
            addCriterion("e_isdel between", value1, value2, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("e_isdel not between", value1, value2, "eIsdel");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeIsNull() {
            addCriterion("e_receivetime is null");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeIsNotNull() {
            addCriterion("e_receivetime is not null");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeEqualTo(Date value) {
            addCriterion("e_receivetime =", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeNotEqualTo(Date value) {
            addCriterion("e_receivetime <>", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeGreaterThan(Date value) {
            addCriterion("e_receivetime >", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_receivetime >=", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeLessThan(Date value) {
            addCriterion("e_receivetime <", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeLessThanOrEqualTo(Date value) {
            addCriterion("e_receivetime <=", value, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeIn(List<Date> values) {
            addCriterion("e_receivetime in", values, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeNotIn(List<Date> values) {
            addCriterion("e_receivetime not in", values, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeBetween(Date value1, Date value2) {
            addCriterion("e_receivetime between", value1, value2, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEReceivetimeNotBetween(Date value1, Date value2) {
            addCriterion("e_receivetime not between", value1, value2, "eReceivetime");
            return (Criteria) this;
        }

        public Criteria andEUpfileIsNull() {
            addCriterion("e_upfile is null");
            return (Criteria) this;
        }

        public Criteria andEUpfileIsNotNull() {
            addCriterion("e_upfile is not null");
            return (Criteria) this;
        }

        public Criteria andEUpfileEqualTo(String value) {
            addCriterion("e_upfile =", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileNotEqualTo(String value) {
            addCriterion("e_upfile <>", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileGreaterThan(String value) {
            addCriterion("e_upfile >", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileGreaterThanOrEqualTo(String value) {
            addCriterion("e_upfile >=", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileLessThan(String value) {
            addCriterion("e_upfile <", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileLessThanOrEqualTo(String value) {
            addCriterion("e_upfile <=", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileLike(String value) {
            addCriterion("e_upfile like", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileNotLike(String value) {
            addCriterion("e_upfile not like", value, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileIn(List<String> values) {
            addCriterion("e_upfile in", values, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileNotIn(List<String> values) {
            addCriterion("e_upfile not in", values, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileBetween(String value1, String value2) {
            addCriterion("e_upfile between", value1, value2, "eUpfile");
            return (Criteria) this;
        }

        public Criteria andEUpfileNotBetween(String value1, String value2) {
            addCriterion("e_upfile not between", value1, value2, "eUpfile");
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