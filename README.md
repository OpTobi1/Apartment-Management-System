# Apartment Management System (OOP)

A Java-based console application designed to manage residential buildings, apartments, and owners. This project was developed as part of an Object-Oriented Programming (OOP) course to demonstrate core concepts such as **Inheritance**, **Polymorphism**, and **Abstract Classes**.

## 🚀 Features

The system allows users to interact with a real estate database through a command-line interface:
- **Manage Buildings:** View apartments by address and type.
- **Ownership Tracking:** Assign apartments to owners and calculate total property value.
- **Smart Filtering:** Find specific apartments (e.g., unsold garden apartments with pools or penthouses).
- **Transaction Simulation:** "Buy" an apartment and update the owner's portfolio and the building's status.
- **Financial Reports:** Calculate total building value and identify the richest owner.

## 🏗️ Project Structure

The project is built using a hierarchical class structure:

### Class Hierarchy
- **`Apartment` (Abstract):** The base class for all housing units. Defines common attributes like area, number, and sales status.
- **`StandardApartment`:** A basic unit that supports up to 2 balconies.
- **`GardenApartment`:** Units that include a garden area and an optional swimming pool.
- **`Penthouse`:** Luxury units with specific pricing models based on balcony and interior size.

### Management Classes
- **`Building`:** Represents a physical structure containing a collection of various `Apartment` objects.
- **`Person`:** Represents an owner. Maintains a dynamic array of owned properties and provides financial summaries.

## 💻 Tech Stack
- **Language:** Java 11+
- **Paradigm:** Object-Oriented Programming
- **Tools:** Java Collections (Arrays), Scanner API
