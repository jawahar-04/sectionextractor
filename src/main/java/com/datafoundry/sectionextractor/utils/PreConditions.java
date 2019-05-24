package com.datafoundry.sectionextractor.utils;


//Adapted from
//https://github.com/eugenp/tutorials/blob/master/spring-boot-rest/src/main/java/com/baeldung/web/util/RestPreconditions.java

/**
* Simple static methods to be called at the start of your own methods to verify correct arguments and state. If the Precondition fails, an {@link HttpStatus} code is thrown
*/
public final class PreConditions {
	 /**
  * Check if some value was true, otherwise throw InvalidInputException exception.
  * 
  * @param expression
  *            has value true if found, otherwise false
  * @throws InvalidInputException
  *             if expression is false, means value not found.
  */
 public static void checkArgument(final boolean expression, String message) {
     if (!expression) {
         throw new InvalidInputException(message);
     }
 }
 
 /**
  * checks if resource is null, otherwise throw exception.
  * 
  * @param expression
  *            has value true if found, otherwise false
  * @throws InvalidInputException
  *             if expression is false, means value not found.
  */
 public static <T> T checkNotNull(final T resource, String message) {
     if (resource == null) {
         throw new InvalidInputException(message);
     }

     return resource;
 }

}

