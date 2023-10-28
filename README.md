# ArtHouse Management System 
<a name="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
          <li><a href="#Features">Features</a></li>
          <li><a href="#Code-Structure">Code Structure</a></li>
          <li><a href="#How-the-Application-Works">How the Application Works</a></li>
          <li><a href="#Menu-Options">Menu Options</a></li>
          <li><a href="#UML">UML</a></li>
         </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
 
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project


Welcome to the ArtHouse application's Data and controller Layer, where I model complex relationships.Where cinema, music and theater all inherit from ArtHouse. Also I manage requests on the server. ArtHouse is an application for managing reservations designed to help manage and acquire data based in specific requirements. In this application, you'll explore how to model complex relationships in a data-driven environment, handle various requests actions, and interact with a MySQL database.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

## Features

The ArtHouse application's provides the following features:
- Get requeste: You can get all the information you want in any class in several ways.
- Post requeste: You can add a field by entering all the information related to it in any class.
- Put requeste: You can update any field in the Cinema or Music classes by entering all the information related to it based on the ID number.
- Patch requeste: You can modify the category property in the Theater class based on the ID number.
- Delete requeste: You can delete any field in any class based on the ID number.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Code_Structure

## Classes
In ArtHouse application's, four main classes play a crucial role: ArtHouse, Cinema, Music, and Theater.

### ArtHouse Class
The ArtHouse class represents a super class in my application. It has the following attributes:

- id:A unique identifier 
- name: name of the child
- duration: Duration of the child
### Cinema Class
The Cinema class represents a child class. It includes:

- id: An auto-incremented unique identifier
- director: Name of the director
- numberOfActors: Cinema's number of actors 
- releaseYear: Cinema's releaseYear
- category: category Cinema's

### Music Class
The Music class represents a child class. It includes:

- id: An auto-incremented unique identifier
- genre: Music's genre
- artist: Music's artist
- releaseYear: Music's release year

### Theater Class
The Theater class represents a child class. It includes:

- id: An auto-incremented unique identifier
- playWright: Theater's play wright
- numberOfActors:  Theater's number of actors
- category:  Theater's category

## Controller 
I have two basic packages under the controller, the first for implementation and the second for interfaces:

## Cinema Controller
I have five get requests under the cinema category:
The first displays all the data in the database
The second displays the data in the database based on the ID number
The third displays the data in the database based on the name of the director
The fourth displays the data in the database based on the year of launch
The fifth displays the data in the database based on the category

## Cinema Interfaces
Displays the signature of all the methods used in the controller.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
