package com.tbsolutions.soc.api.controller.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator for different kind of inputs
 *
 * @author adelrioj
 */
public class Validator {

    public static final String HAS_SPECIAL_CHARACTERS_CASE_INSENSITIVE_REGEX = "[^a-z0-9 .]";

    /**
     * Return true if input String has no characters included in {@link Validator#HAS_SPECIAL_CHARACTERS_CASE_INSENSITIVE_REGEX}
     * @param toValidate String that needs validation
     * @return boolean with validation result
     */
    public static boolean hasSpecialCharacters(String toValidate){
        Pattern pattern = Pattern.compile(HAS_SPECIAL_CHARACTERS_CASE_INSENSITIVE_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(toValidate);
        return matcher.find();
    }

    /**
     * Return true if input String matches valid mail address
     * @param emailAdrressToValidate email address that needs validation
     * @return boolean with validation result
     * @see EmailValidator
     */
    public static boolean isValidEmailAddress(String emailAdrressToValidate){
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(emailAdrressToValidate);
    }

    /**
     * Return true if input is not:
     * <ul>
     *     <li>null</li>
     *     <li>empty String</li>
     *     <li>null value String</li>
     *     <li>nil value String</li>
     *     <li>none value String</li>
     * </ul>
     * @param toValidate String that needs validation
     * @return boolean with validation result
     */
    public static boolean isNotNull(String toValidate){
        if (toValidate == null) return false;
        if (toValidate.isEmpty()) return false;
        toValidate = toValidate.toUpperCase().trim();
        if ("".equals(toValidate)) return false;
        if ("NULL".equals(toValidate)) return false;
        if ("NONE".equals(toValidate)) return false;
        if ("NIL".equals(toValidate)) return false;
        return true;
    }

    /**
     * Opposite to {@link Validator#isNotNull(java.lang.String)}
     * @param toValidate String that needs validation
     * @return boolean with validation result
     */
    public static boolean isNull(String toValidate){
        return !isNotNull(toValidate);
    }

    /**
     * Return true if input is not:
     * <ul>
     *     <li>null</li>
     * </ul>
     * @param toValidate Object that needs validation
     * @return boolean with validation result
     */
    public static boolean isNotNull(Object toValidate){
        if (toValidate == null) return false;
        return true;
    }

    /**
     * Return true if input is NOT:
     * <ul>
     *     <li>null</li>
     *     <li>input.isEmpty()</li>
     * </ul>
     * @param toValidate Collection that needs validation
     * @return boolean with validation result
     */
    public static boolean isNotEmptyOrNull(Collection toValidate){
        if (toValidate == null) return false;
        if (toValidate.isEmpty()) return false;
        return true;
    }

    /**
     * Opposite to {@link Validator#isNotEmptyOrNull(java.util.Collection)}
     * @param toValidate Collection that needs validation
     * @return boolean with validation result
     */
    public static boolean isEmptyOrNull(Collection toValidate){
        return !isNotEmptyOrNull(toValidate);
    }

    /**
     * If iterable == null returns Collections.emptyList()
     * Collections.emptyList() is IMMUTABLE, so it's impossible to add objects to it.
     */
    public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
        return iterable == null ? Collections.<T>emptyList() : iterable;
    }
}
