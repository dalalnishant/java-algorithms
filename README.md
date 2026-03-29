# Java Algorithms

A collection of common algorithms implemented in Java, with unit tests using JUnit 5.

## Tech Stack

| Tool | Version |
|------|---------|
| Java | 21 |
| JUnit Jupiter | 5.10.0 |
| Maven Compiler Plugin | 3.12.1 |
| Maven Surefire Plugin | 3.2.5 |

## Project Info

| Property | Value |
|----------|-------|
| Group ID | com.algorithms |
| Artifact ID | java-algorithms |
| Version | 1.0-SNAPSHOT |
| Encoding | UTF-8 |

## Project Structure
```
src/
├── main/java/com/algorithms/   # Algorithm implementations
└── test/java/com/algorithms/   # Unit tests
```

## Getting Started

**Clone the repository**
```bash
git clone https://github.com/dalalnishant/java-algorithms.git
cd java-algorithms
```

**Compile the project**
```bash
mvn compile
```

**Run all tests**
```bash
mvn test
```

**Clean and build**
```bash
mvn clean install
```

## Algorithms Covered

### Sorting

| Algorithm | Best Case | Average Case | Worst Case | Space |
|-----------|-----------|--------------|------------|-------|
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |

> 🚧 More algorithms will be added progressively.

## License

MIT
