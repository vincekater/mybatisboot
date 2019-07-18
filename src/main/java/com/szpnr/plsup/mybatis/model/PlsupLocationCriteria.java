package com.szpnr.plsup.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class PlsupLocationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlsupLocationCriteria() {
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

        public Criteria andLocationIdIsNull() {
            addCriterion("LOCATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("LOCATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Short value) {
            addCriterion("LOCATION_ID =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Short value) {
            addCriterion("LOCATION_ID <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Short value) {
            addCriterion("LOCATION_ID >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCATION_ID >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Short value) {
            addCriterion("LOCATION_ID <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Short value) {
            addCriterion("LOCATION_ID <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Short> values) {
            addCriterion("LOCATION_ID in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Short> values) {
            addCriterion("LOCATION_ID not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Short value1, Short value2) {
            addCriterion("LOCATION_ID between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Short value1, Short value2) {
            addCriterion("LOCATION_ID not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNull() {
            addCriterion("LOCATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLocationNameIsNotNull() {
            addCriterion("LOCATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNameEqualTo(String value) {
            addCriterion("LOCATION_NAME =", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotEqualTo(String value) {
            addCriterion("LOCATION_NAME <>", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThan(String value) {
            addCriterion("LOCATION_NAME >", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_NAME >=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThan(String value) {
            addCriterion("LOCATION_NAME <", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_NAME <=", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameLike(String value) {
            addCriterion("LOCATION_NAME like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotLike(String value) {
            addCriterion("LOCATION_NAME not like", value, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameIn(List<String> values) {
            addCriterion("LOCATION_NAME in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotIn(List<String> values) {
            addCriterion("LOCATION_NAME not in", values, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameBetween(String value1, String value2) {
            addCriterion("LOCATION_NAME between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationNameNotBetween(String value1, String value2) {
            addCriterion("LOCATION_NAME not between", value1, value2, "locationName");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIsNull() {
            addCriterion("LOCATION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIsNotNull() {
            addCriterion("LOCATION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeEqualTo(String value) {
            addCriterion("LOCATION_CODE =", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeNotEqualTo(String value) {
            addCriterion("LOCATION_CODE <>", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeGreaterThan(String value) {
            addCriterion("LOCATION_CODE >", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE >=", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeLessThan(String value) {
            addCriterion("LOCATION_CODE <", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE <=", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeLike(String value) {
            addCriterion("LOCATION_CODE like", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeNotLike(String value) {
            addCriterion("LOCATION_CODE not like", value, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIn(List<String> values) {
            addCriterion("LOCATION_CODE in", values, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeNotIn(List<String> values) {
            addCriterion("LOCATION_CODE not in", values, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE between", value1, value2, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeNotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE not between", value1, value2, "locationCode");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIsNull() {
            addCriterion("LOCATION_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIsNotNull() {
            addCriterion("LOCATION_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLevelEqualTo(String value) {
            addCriterion("LOCATION_LEVEL =", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotEqualTo(String value) {
            addCriterion("LOCATION_LEVEL <>", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelGreaterThan(String value) {
            addCriterion("LOCATION_LEVEL >", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_LEVEL >=", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelLessThan(String value) {
            addCriterion("LOCATION_LEVEL <", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_LEVEL <=", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelLike(String value) {
            addCriterion("LOCATION_LEVEL like", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotLike(String value) {
            addCriterion("LOCATION_LEVEL not like", value, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelIn(List<String> values) {
            addCriterion("LOCATION_LEVEL in", values, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotIn(List<String> values) {
            addCriterion("LOCATION_LEVEL not in", values, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelBetween(String value1, String value2) {
            addCriterion("LOCATION_LEVEL between", value1, value2, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andLocationLevelNotBetween(String value1, String value2) {
            addCriterion("LOCATION_LEVEL not between", value1, value2, "locationLevel");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("PARENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("PARENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("PARENT_CODE =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("PARENT_CODE <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("PARENT_CODE >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_CODE >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("PARENT_CODE <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("PARENT_CODE <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("PARENT_CODE like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("PARENT_CODE not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("PARENT_CODE in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("PARENT_CODE not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("PARENT_CODE between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("PARENT_CODE not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisIsNull() {
            addCriterion("LOCATION_CODE_JCGIS is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisIsNotNull() {
            addCriterion("LOCATION_CODE_JCGIS is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisEqualTo(String value) {
            addCriterion("LOCATION_CODE_JCGIS =", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisNotEqualTo(String value) {
            addCriterion("LOCATION_CODE_JCGIS <>", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisGreaterThan(String value) {
            addCriterion("LOCATION_CODE_JCGIS >", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_JCGIS >=", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisLessThan(String value) {
            addCriterion("LOCATION_CODE_JCGIS <", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_JCGIS <=", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisLike(String value) {
            addCriterion("LOCATION_CODE_JCGIS like", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisNotLike(String value) {
            addCriterion("LOCATION_CODE_JCGIS not like", value, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisIn(List<String> values) {
            addCriterion("LOCATION_CODE_JCGIS in", values, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisNotIn(List<String> values) {
            addCriterion("LOCATION_CODE_JCGIS not in", values, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_JCGIS between", value1, value2, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeJcgisNotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_JCGIS not between", value1, value2, "locationCodeJcgis");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1IsNull() {
            addCriterion("LOCATION_CODE_IBMS1 is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1IsNotNull() {
            addCriterion("LOCATION_CODE_IBMS1 is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1EqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS1 =", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1NotEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS1 <>", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1GreaterThan(String value) {
            addCriterion("LOCATION_CODE_IBMS1 >", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1GreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS1 >=", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1LessThan(String value) {
            addCriterion("LOCATION_CODE_IBMS1 <", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1LessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS1 <=", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1Like(String value) {
            addCriterion("LOCATION_CODE_IBMS1 like", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1NotLike(String value) {
            addCriterion("LOCATION_CODE_IBMS1 not like", value, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1In(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS1 in", values, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1NotIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS1 not in", values, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1Between(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS1 between", value1, value2, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms1NotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS1 not between", value1, value2, "locationCodeIbms1");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2IsNull() {
            addCriterion("LOCATION_CODE_IBMS2 is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2IsNotNull() {
            addCriterion("LOCATION_CODE_IBMS2 is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2EqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS2 =", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2NotEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS2 <>", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2GreaterThan(String value) {
            addCriterion("LOCATION_CODE_IBMS2 >", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2GreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS2 >=", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2LessThan(String value) {
            addCriterion("LOCATION_CODE_IBMS2 <", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2LessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS2 <=", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2Like(String value) {
            addCriterion("LOCATION_CODE_IBMS2 like", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2NotLike(String value) {
            addCriterion("LOCATION_CODE_IBMS2 not like", value, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2In(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS2 in", values, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2NotIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS2 not in", values, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2Between(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS2 between", value1, value2, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbms2NotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS2 not between", value1, value2, "locationCodeIbms2");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("IS_DEL like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("IS_DEL not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andLocationAddrIsNull() {
            addCriterion("LOCATION_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andLocationAddrIsNotNull() {
            addCriterion("LOCATION_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andLocationAddrEqualTo(String value) {
            addCriterion("LOCATION_ADDR =", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrNotEqualTo(String value) {
            addCriterion("LOCATION_ADDR <>", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrGreaterThan(String value) {
            addCriterion("LOCATION_ADDR >", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_ADDR >=", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrLessThan(String value) {
            addCriterion("LOCATION_ADDR <", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_ADDR <=", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrLike(String value) {
            addCriterion("LOCATION_ADDR like", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrNotLike(String value) {
            addCriterion("LOCATION_ADDR not like", value, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrIn(List<String> values) {
            addCriterion("LOCATION_ADDR in", values, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrNotIn(List<String> values) {
            addCriterion("LOCATION_ADDR not in", values, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrBetween(String value1, String value2) {
            addCriterion("LOCATION_ADDR between", value1, value2, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationAddrNotBetween(String value1, String value2) {
            addCriterion("LOCATION_ADDR not between", value1, value2, "locationAddr");
            return (Criteria) this;
        }

        public Criteria andLocationTelIsNull() {
            addCriterion("LOCATION_TEL is null");
            return (Criteria) this;
        }

        public Criteria andLocationTelIsNotNull() {
            addCriterion("LOCATION_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andLocationTelEqualTo(String value) {
            addCriterion("LOCATION_TEL =", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelNotEqualTo(String value) {
            addCriterion("LOCATION_TEL <>", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelGreaterThan(String value) {
            addCriterion("LOCATION_TEL >", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_TEL >=", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelLessThan(String value) {
            addCriterion("LOCATION_TEL <", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_TEL <=", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelLike(String value) {
            addCriterion("LOCATION_TEL like", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelNotLike(String value) {
            addCriterion("LOCATION_TEL not like", value, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelIn(List<String> values) {
            addCriterion("LOCATION_TEL in", values, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelNotIn(List<String> values) {
            addCriterion("LOCATION_TEL not in", values, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelBetween(String value1, String value2) {
            addCriterion("LOCATION_TEL between", value1, value2, "locationTel");
            return (Criteria) this;
        }

        public Criteria andLocationTelNotBetween(String value1, String value2) {
            addCriterion("LOCATION_TEL not between", value1, value2, "locationTel");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneIsNull() {
            addCriterion("LOCATION_CODE_IBMS_ZONE is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneIsNotNull() {
            addCriterion("LOCATION_CODE_IBMS_ZONE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE =", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneNotEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE <>", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneGreaterThan(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE >", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE >=", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneLessThan(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE <", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE <=", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneLike(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE like", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneNotLike(String value) {
            addCriterion("LOCATION_CODE_IBMS_ZONE not like", value, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS_ZONE in", values, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneNotIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS_ZONE not in", values, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS_ZONE between", value1, value2, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsZoneNotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS_ZONE not between", value1, value2, "locationCodeIbmsZone");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubIsNull() {
            addCriterion("LOCATION_CODE_IBMS_SUB is null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubIsNotNull() {
            addCriterion("LOCATION_CODE_IBMS_SUB is not null");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB =", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubNotEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB <>", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubGreaterThan(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB >", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB >=", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubLessThan(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB <", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB <=", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubLike(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB like", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubNotLike(String value) {
            addCriterion("LOCATION_CODE_IBMS_SUB not like", value, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS_SUB in", values, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubNotIn(List<String> values) {
            addCriterion("LOCATION_CODE_IBMS_SUB not in", values, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS_SUB between", value1, value2, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationCodeIbmsSubNotBetween(String value1, String value2) {
            addCriterion("LOCATION_CODE_IBMS_SUB not between", value1, value2, "locationCodeIbmsSub");
            return (Criteria) this;
        }

        public Criteria andLocationAreaIsNull() {
            addCriterion("LOCATION_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLocationAreaIsNotNull() {
            addCriterion("LOCATION_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLocationAreaEqualTo(Short value) {
            addCriterion("LOCATION_AREA =", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaNotEqualTo(Short value) {
            addCriterion("LOCATION_AREA <>", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaGreaterThan(Short value) {
            addCriterion("LOCATION_AREA >", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCATION_AREA >=", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaLessThan(Short value) {
            addCriterion("LOCATION_AREA <", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaLessThanOrEqualTo(Short value) {
            addCriterion("LOCATION_AREA <=", value, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaIn(List<Short> values) {
            addCriterion("LOCATION_AREA in", values, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaNotIn(List<Short> values) {
            addCriterion("LOCATION_AREA not in", values, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaBetween(Short value1, Short value2) {
            addCriterion("LOCATION_AREA between", value1, value2, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationAreaNotBetween(Short value1, Short value2) {
            addCriterion("LOCATION_AREA not between", value1, value2, "locationArea");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeIsNull() {
            addCriterion("LOCATION_IBMS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeIsNotNull() {
            addCriterion("LOCATION_IBMS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeEqualTo(String value) {
            addCriterion("LOCATION_IBMS_CODE =", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeNotEqualTo(String value) {
            addCriterion("LOCATION_IBMS_CODE <>", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeGreaterThan(String value) {
            addCriterion("LOCATION_IBMS_CODE >", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_IBMS_CODE >=", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeLessThan(String value) {
            addCriterion("LOCATION_IBMS_CODE <", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_IBMS_CODE <=", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeLike(String value) {
            addCriterion("LOCATION_IBMS_CODE like", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeNotLike(String value) {
            addCriterion("LOCATION_IBMS_CODE not like", value, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeIn(List<String> values) {
            addCriterion("LOCATION_IBMS_CODE in", values, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeNotIn(List<String> values) {
            addCriterion("LOCATION_IBMS_CODE not in", values, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeBetween(String value1, String value2) {
            addCriterion("LOCATION_IBMS_CODE between", value1, value2, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsCodeNotBetween(String value1, String value2) {
            addCriterion("LOCATION_IBMS_CODE not between", value1, value2, "locationIbmsCode");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelIsNull() {
            addCriterion("LOCATION_IBMS_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelIsNotNull() {
            addCriterion("LOCATION_IBMS_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelEqualTo(String value) {
            addCriterion("LOCATION_IBMS_LEVEL =", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelNotEqualTo(String value) {
            addCriterion("LOCATION_IBMS_LEVEL <>", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelGreaterThan(String value) {
            addCriterion("LOCATION_IBMS_LEVEL >", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION_IBMS_LEVEL >=", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelLessThan(String value) {
            addCriterion("LOCATION_IBMS_LEVEL <", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelLessThanOrEqualTo(String value) {
            addCriterion("LOCATION_IBMS_LEVEL <=", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelLike(String value) {
            addCriterion("LOCATION_IBMS_LEVEL like", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelNotLike(String value) {
            addCriterion("LOCATION_IBMS_LEVEL not like", value, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelIn(List<String> values) {
            addCriterion("LOCATION_IBMS_LEVEL in", values, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelNotIn(List<String> values) {
            addCriterion("LOCATION_IBMS_LEVEL not in", values, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelBetween(String value1, String value2) {
            addCriterion("LOCATION_IBMS_LEVEL between", value1, value2, "locationIbmsLevel");
            return (Criteria) this;
        }

        public Criteria andLocationIbmsLevelNotBetween(String value1, String value2) {
            addCriterion("LOCATION_IBMS_LEVEL not between", value1, value2, "locationIbmsLevel");
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