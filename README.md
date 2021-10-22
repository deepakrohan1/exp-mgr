# Expense Manager App

## CI

[![CircleCI](https://circleci.com/gh/deepakrohan1/exp-mgr/tree/master.svg?style=svg)](https://circleci.com/gh/deepakrohan1/exp-mgr/tree/master)


## Description 

The application takes in expenses and categories and calculate the total amount.
Set fixed number of categories and set an upper bound amount. Once you add the expenses 
to the categories along with the amount it totals the amount. When the total amount spent
crosses the threshold it triggers a notification to the user.

## Project Env Setup 

```$xslt
gradle build
gradle bootRun
```

Visit `http://localhost:8080/swagger-ui.html`

### Lombok Framework

Project uses lombok framework to create `getters`, `setters`, `constructors` and `builder` patterns 
for Entities and Data Transfer Objects 

```$xslt
@ApiModel("To Handle Category requests sent by API")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(value = {"dateAdded"})
public class CategoryDto {}
```

### MapStrut

The variable names change between actual data elements to the response key names. instead
of using a java class to handle conversions. MapStrut mapping interfaces are used.

```$xslt
   @Mapping(source = "category", target = "expenseCat")
    @Mapping(source = "categoryDesc", target = "expenseCatDesc")
    @Mapping(source = "amount", target = "amtCategoryAlloted")
    @Mapping(source = "dateAdded", target = "timeCategoryCreated")
    Category categoryDtoToCategory(CategoryDto categoryDto);
```
Once this is available you can just use the method when the conversion has to happen.

## ControllerAdvice 

To handle exceptions we use a class which extends `ResponseEntityExceptionHandler` and annotated
with `@ControllerAdvice`. Generic method to handle all exceptions and custom Exceptions are added 
and meaningful response object is returned

```$xslt
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .timeOfException(LocalDateTime.now())
                .exception(exception.getMessage())
                .description(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
```

