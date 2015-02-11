Java 8 In Action Katas
===========

Coding beer session for quick introduction in .

# Preconditions
- IDE with JDK 8 and Maven support

It is fairly easy to work with jOOQ, so feel free to experiment. Use the http://www.jooq.org/learn/ manuals for reference.

# Code generation
(more info: http://www.jooq.org/doc/3.4/manual/code-generation/codegen-configuration/)

You can use jOOQ to generate class hierarchy out of database structure that can be used for typesafe queries or easy CRUD operations.
This can be set up easily using maven plugin. The code generation is run together with the `package` goal.

Generation parameters can be set up inside the `<generator>` tag:

# Assignment 1
Set up and prepare the code generation via Maven plugin. Checkout `<!-- Generator parameters -->` in pom.xml
*Goal: `CrudDaoTest` should pass*  

# Assignment 2
Implement methods in the `CodingBeer` interface so that all the tests in `CodingBeerTest` pass without problems. 
You can use the `Connection.INSTANCE.getConnection()` helper class for obtaining the connection from the pool.

```
public interface CodingBeer {

    public int countAllCities();

    public String fetchCityWithMostInhabitants();

    public Map<String, String> fetchEuropeanCountriesWithCapitals();

    public int numberOfPeopleSpeakingChinese();

    void addPerson(String name, Integer age, Integer city);

    public java.util.List<String> findOldestPeopleNames();

    void deleteAllPersons();
    
}
```

# Fun stuff
Sql2Jooq - generate jOOQ code out of plain SQL. It's not part of the official jOOQ distribution, since it uses 3rd party libraries.
Play around with the sample in `Sql2JooqTest`. 

Good luck and have fun :)
