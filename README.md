Below is a comprehensive documentation guide for setting up Lombok in your Spring Boot project, along with troubleshooting tips if you encounter issues like the `cannot find symbol` error for Lombok-generated methods.

---

# Lombok Integration and Troubleshooting Guide

This documentation explains how to integrate Lombok into your Spring Boot project, configure your IDE correctly, and troubleshoot common issues.

---

## 1. Overview

Lombok is a Java library that minimizes boilerplate code by automatically generating getters, setters, constructors, and other common methods at compile time. In Spring Boot projects, Lombok simplifies your code by reducing manual implementations of such methods.

---

## 2. Updating the `pom.xml`

### 2.1 Adding the Lombok Dependency

Ensure that you have added Lombok to your Maven project with the correct version and scope. Replace your existing Lombok configuration with the following:

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.30</version> <!-- Specify the latest or required version -->
  <scope>provided</scope>       <!-- Lombok is only needed at compile time -->
</dependency>
```

### 2.2 Configuring the Maven Compiler Plugin

Within the `<build>` section of your `pom.xml`, ensure that the annotation processor paths include Lombok with the version specified:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                        <version>1.18.30</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
        <!-- Other plugins (e.g., spring-boot-maven-plugin) go here -->
    </plugins>
</build>
```

*Save your changes and reload the Maven project in your IDE.*

---

## 3. IDE Configuration

### 3.1 IntelliJ IDEA

- **Lombok Plugin:**
  - Go to **File → Settings → Plugins**.
  - Search for **"Lombok"** and ensure it is installed and enabled.
  
- **Annotation Processing:**
  - Navigate to **File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors**.
  - Ensure that **"Enable annotation processing"** is checked.

### 3.2 Eclipse

- **Lombok Integration:**
  - Download the Lombok jar from the official website and run it.
  - The installer will guide you through integrating Lombok with Eclipse.
  - Ensure that the Lombok jar is correctly attached to your Eclipse installation.

---

## 4. Refresh and Rebuild the Project

### 4.1 Reload Maven

- In **IntelliJ IDEA**, right-click on your project → **Maven → Reload Project** (or click the Maven refresh icon).

### 4.2 Rebuild the Project

- Go to **Build → Rebuild Project** in your IDE.
- Alternatively, run the following command from the terminal at your project root:
  ```bash
  mvn clean install
  ```

---

## 5. Verification

### 5.1 Verify Lombok-Generated Code

- In your DTO classes (e.g., `LoginForm`), ensure that you have Lombok annotations such as `@Getter` and `@Setter`.  
- Example `LoginForm.java`:
  ```java
  package com.example.demo.dto;

  import jakarta.validation.constraints.Email;
  import jakarta.validation.constraints.NotBlank;
  import jakarta.validation.constraints.Size;
  import lombok.Getter;
  import lombok.Setter;

  @Setter
  @Getter
  public class LoginForm {
      @NotBlank(message = "Email is required")
      @Email(message = "Invalid email format")
      private String email;

      @NotBlank(message = "Password is required")
      @Size(min = 6, message = "Password must be at least 6 characters long")
      private String password;
  }
  ```
- After rebuilding, the IDE should recognize the generated methods (e.g., `getEmail()`, `setEmail()`).

### 5.2 Check Maven Dependency Tree

- Run `mvn dependency:tree` to verify that Lombok is included as expected.

---

## 6. Troubleshooting Steps

If you still encounter issues like `cannot find symbol: method getEmail()`, try the following:

1. **Confirm Dependency and Version:**
   - Double-check your `pom.xml` for a properly specified Lombok dependency, both in the dependencies section and in the Maven Compiler Plugin.

2. **Invalidate Caches / Restart:**
   - In IntelliJ IDEA, go to **File → Invalidate Caches / Restart**, then choose **Invalidate and Restart**.

3. **Clean and Re-import:**
   - Delete the `target` directory to clear any cached artifacts.
   - Re-import the project into your IDE to ensure a fresh build.

4. **Inspect the Build Output:**
   - Check the full build logs for any additional warnings or errors that might hint at issues with Lombok or annotation processing.

5. **Verify Correct Class Usage:**
   - Ensure that you are referencing the correct class (`LoginForm`) without any naming conflicts or duplicate classes in your project.

---

## 7. Additional Resources

- **Lombok Official Documentation:**  
  [Project Lombok Documentation](https://projectlombok.org/features)
  
- **Spring Boot Documentation:**  
  [Spring Boot Reference Guide](https://spring.io/projects/spring-boot)

- **IDE-Specific Guides:**
  - [IntelliJ IDEA Lombok Plugin Setup](https://www.jetbrains.com/help/idea/lombok.html)
  - [Eclipse and Lombok Integration](https://projectlombok.org/setup/eclipse)

---

This documentation should help you set up Lombok properly in your Spring Boot project and resolve the `cannot find symbol` errors caused by unrecognized Lombok-generated methods. If further issues persist, recheck each step or consult the additional resources for more detailed troubleshooting tips.
