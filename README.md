# Recipe Collection Program

## Overview

The Recipe Collection program is a Java-based console application that allows users to create, view, and scale recipes.  
It provides a menu-driven interface where users can add recipes, list them, scale ingredient quantities, and view updated calorie counts.

This project demonstrates:

- Java classes and encapsulation
- Use of `ArrayList` for managing collections
- Implementation of control structures and algorithms
- Custom methods with both value-returning and void functionality
- Inline comments and Javadoc reference documentation
- Unit testing with assertions

---

## Features

- **Create a recipe** – Add a name, servings, and a list of ingredients with amounts, units, and calories per unit.
- **Scale recipes** – Adjust ingredient amounts and servings proportionally using a scale factor.
- **Calorie calculation** – Automatic total and per-serving calorie calculation.
- **View recipes** – Display all recipe details in a clear format.
- **Menu-driven navigation** – Interactive console interface.
- **Reference documentation** – Javadoc-generated API documentation included in `src/`.

## Project Structure

src/
├── Ingredient.java # Represents a single ingredient
├── Recipe.java # Represents a recipe and its behaviors
├── Main.java # Main driver class with menu and user interaction
├── Recipe_Test.java # Unit test class with assertions
├── index.html # Entry point for Javadoc API documentation
├── [other Javadoc files] # Supporting HTML, CSS, and script files

---

## How to Run

1. **Compile the program**

```bash
javac src/*.java
```

2.**Run the program**

```bash
java -cp src Main
```

### Viewing the Javadocs ###

1. Open src/index.html in any web browser.
2. Browse the generated API documentation for Ingredient, Recipe, Main, and other classes.

**Requirements**
-Java 17 or later
-Console or terminal access

## 🚀 Improvement Roadmap

While the current version provides a fully functional recipe management system, there are opportunities for future enhancements:

### Assignment 1: Add Recipe Steps and Tags   

- ~~Implement functionality to store **step-by-step cooking instructions** for each recipe.~~
- ~~Implement functionality to store **Tags** for each recipe.~~
- ~~Add methods to add, edit, and display steps.~~  
- ~~Modify the `printRecipe()` method to display steps in order.~~  

### Assignment 2: Enhanced User Interface  

- Develop a **front-end interface** (e.g., JavaFX or a simple web front-end).  
- Provide an interactive form for adding recipes, ingredients, and steps.  
- Improve user experience with better formatting and error handling.  

### Assignment 3: Database Integration  

- Store recipes, ingredients, and steps in a **relational database** (e.g., MySQL or SQLite).  
- Implement CRUD (Create, Read, Update, Delete) operations.  
- Enable persistent storage so recipes are saved between program executions.  

### Assignment 4: Advanced Features  

- Add **search and filter functionality** (e.g., by calories, ingredient, or serving size).  
- Implement recipe **scaling with nutrition recalculation**.  
- Add export options (e.g., save recipes as PDF, JSON, or CSV).  

---

**Author**
Tevin Davis – Created for IT 145 Object Oriented Programming Final Project
