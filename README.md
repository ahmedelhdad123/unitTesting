# Unit Testing Task

This project demonstrates unit testing of a simple e-commerce application. It includes basic functionalities for managing customer accounts and purchasing products from a store. The application is built using Java and includes tests using JUnit and Mockito for unit testing.

## Project Structure

The project consists of the following main components:

1. **Account Management**: Handles customer accounts, including deposits and withdrawals.
2. **Store Management**: Manages products and handles purchases.
3. **Unit Tests**: Tests for both account management and store functionalities.

## Components

### 1. Account Management

#### `AccountManager` Interface

Defines the methods for managing customer accounts.

#### `AccountManagerImpl` Class

Implements the `AccountManager` interface with logic for deposits and withdrawals. It ensures that withdrawals handle insufficient balances, credit allowance, and VIP customer status.

#### `Customer` Class

Represents a customer with properties such as name, balance, credit allowance, and VIP status.

### 2. Store Management

#### `Product` Class

Represents a product with properties such as name, price, and quantity.

#### `Store` Interface

Defines the method for buying a product.

#### `StoreImpl` Class

Implements the `Store` interface with logic for purchasing a product. It ensures product availability and handles payment status.

### 3. Unit Tests

#### `AccountManagerTest` Class

Contains tests for account management functionalities. It tests various scenarios such as sufficient balance, credit allowed, credit not allowed, and exceeding credit limit.

#### `StoreTest` Class

Contains tests for store functionalities using Mockito for mocking dependencies. It tests scenarios such as successful purchase, out-of-stock products, and payment failures.

## Conclusion

This project demonstrates the use of unit testing in Java to ensure the correctness of account management and store functionalities. It covers various test scenarios, including successful transactions, out-of-stock products, and payment failures.
