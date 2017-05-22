package com.dm.stu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNull() {
            addCriterion("menu_pid is null");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNotNull() {
            addCriterion("menu_pid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPidEqualTo(String value) {
            addCriterion("menu_pid =", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotEqualTo(String value) {
            addCriterion("menu_pid <>", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThan(String value) {
            addCriterion("menu_pid >", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThanOrEqualTo(String value) {
            addCriterion("menu_pid >=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThan(String value) {
            addCriterion("menu_pid <", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThanOrEqualTo(String value) {
            addCriterion("menu_pid <=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLike(String value) {
            addCriterion("menu_pid like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotLike(String value) {
            addCriterion("menu_pid not like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidIn(List<String> values) {
            addCriterion("menu_pid in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotIn(List<String> values) {
            addCriterion("menu_pid not in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidBetween(String value1, String value2) {
            addCriterion("menu_pid between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotBetween(String value1, String value2) {
            addCriterion("menu_pid not between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberIsNull() {
            addCriterion("menu_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberIsNotNull() {
            addCriterion("menu_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberEqualTo(Integer value) {
            addCriterion("menu_serial_number =", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberNotEqualTo(Integer value) {
            addCriterion("menu_serial_number <>", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberGreaterThan(Integer value) {
            addCriterion("menu_serial_number >", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_serial_number >=", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberLessThan(Integer value) {
            addCriterion("menu_serial_number <", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("menu_serial_number <=", value, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberIn(List<Integer> values) {
            addCriterion("menu_serial_number in", values, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberNotIn(List<Integer> values) {
            addCriterion("menu_serial_number not in", values, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("menu_serial_number between", value1, value2, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_serial_number not between", value1, value2, "menuSerialNumber");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("menu_icon is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("menu_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("menu_icon =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("menu_icon <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("menu_icon >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("menu_icon >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("menu_icon <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("menu_icon <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("menu_icon like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("menu_icon not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("menu_icon in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("menu_icon not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("menu_icon between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("menu_icon not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixIsNull() {
            addCriterion("menu_prefix is null");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixIsNotNull() {
            addCriterion("menu_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixEqualTo(String value) {
            addCriterion("menu_prefix =", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixNotEqualTo(String value) {
            addCriterion("menu_prefix <>", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixGreaterThan(String value) {
            addCriterion("menu_prefix >", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("menu_prefix >=", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixLessThan(String value) {
            addCriterion("menu_prefix <", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixLessThanOrEqualTo(String value) {
            addCriterion("menu_prefix <=", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixLike(String value) {
            addCriterion("menu_prefix like", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixNotLike(String value) {
            addCriterion("menu_prefix not like", value, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixIn(List<String> values) {
            addCriterion("menu_prefix in", values, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixNotIn(List<String> values) {
            addCriterion("menu_prefix not in", values, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixBetween(String value1, String value2) {
            addCriterion("menu_prefix between", value1, value2, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuPrefixNotBetween(String value1, String value2) {
            addCriterion("menu_prefix not between", value1, value2, "menuPrefix");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefIsNull() {
            addCriterion("menu_ui_sref is null");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefIsNotNull() {
            addCriterion("menu_ui_sref is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefEqualTo(String value) {
            addCriterion("menu_ui_sref =", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefNotEqualTo(String value) {
            addCriterion("menu_ui_sref <>", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefGreaterThan(String value) {
            addCriterion("menu_ui_sref >", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefGreaterThanOrEqualTo(String value) {
            addCriterion("menu_ui_sref >=", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefLessThan(String value) {
            addCriterion("menu_ui_sref <", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefLessThanOrEqualTo(String value) {
            addCriterion("menu_ui_sref <=", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefLike(String value) {
            addCriterion("menu_ui_sref like", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefNotLike(String value) {
            addCriterion("menu_ui_sref not like", value, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefIn(List<String> values) {
            addCriterion("menu_ui_sref in", values, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefNotIn(List<String> values) {
            addCriterion("menu_ui_sref not in", values, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefBetween(String value1, String value2) {
            addCriterion("menu_ui_sref between", value1, value2, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuUiSrefNotBetween(String value1, String value2) {
            addCriterion("menu_ui_sref not between", value1, value2, "menuUiSref");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIsNull() {
            addCriterion("menu_status is null");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIsNotNull() {
            addCriterion("menu_status is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStatusEqualTo(Boolean value) {
            addCriterion("menu_status =", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotEqualTo(Boolean value) {
            addCriterion("menu_status <>", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusGreaterThan(Boolean value) {
            addCriterion("menu_status >", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("menu_status >=", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusLessThan(Boolean value) {
            addCriterion("menu_status <", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("menu_status <=", value, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusIn(List<Boolean> values) {
            addCriterion("menu_status in", values, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotIn(List<Boolean> values) {
            addCriterion("menu_status not in", values, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_status between", value1, value2, "menuStatus");
            return (Criteria) this;
        }

        public Criteria andMenuStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_status not between", value1, value2, "menuStatus");
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