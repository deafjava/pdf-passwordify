# PDF Passwordify
Welcome to PDF Passwordify, a Clojure project designed to add password protection to your PDF files.

## Features
Password Protection: Secure your PDF files by adding a password.
Command Line Interface: Easy to use command line interface for password protection.
## Structure
The Hexagonal Architecture, also known as Ports and Adapters, is a design pattern that aims to create a loosely coupled application that can be easily connected to its software environment. This is achieved by structuring the application into three main parts:

Domain: This is the core of the application, containing the business logic. It is technology-agnostic and doesn't depend on any external elements such as databases or UIs.

Ports: These are interfaces that define the inputs and outputs of the domain. There are two types of ports: primary (or driving) ports, which are called by the application, and secondary (or driven) ports, which are called by the infrastructure.

Adapters: These are the implementations of the ports. They translate the data between the format used in the domain and the format used by the external elements.

In the context of the PDF Passwordify project, the components can be mapped to the Hexagonal Architecture as follows:

Controller: This can be seen as a primary adapter. It handles the user interface, which includes the command line interface (CLI) and the system operations (SO), and calls the appropriate logic in the domain.

Diplomat: This component can be seen as a "Port". It defines the contract for how the application interacts with the outside world. It handles the output of results and system operations, effectively serving as the interface between the core application (the "Logic") and the external systems (like the file system or the user interface).

Logic: This is the domain of the application. It contains the core logic of the application, including the CLI and SO.
## Usage
To use PDF Passwordify, you need to have Clojure installed on your system. Once you have that, you can run the project using the command line interface.

## License
PDF Passwordify is licensed under the Eclipse Public License 1.0.
