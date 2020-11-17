import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import { UserService } from './service/UserService';
import { render } from '@testing-library/react';
//import de datatable
import  {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';

//Este es nuestro componente base y podemos utilizar tanto funciones como clases
//para programar nuestros componenes, este componente es el que no sale cuando corremos el proyecto
//A la hora de crear una clase debemos de extender de component para asi crear nuestros componentes
//Se debe de agregar el default para que esta clase se pueda agregar a nuestro index.js sin ningun problema
export default class App extends Component{

  //Este constructor es un paso basico para asi poder hacer uso de la clase servicios y sus metodos
  constructor(){
    super();
    this.state = {};
    this.userService = new UserService();
  }

  //Creo un componente donde llamo a la funcion get all para obtener todos los usuarios
  componentDidMount(){
    //esto quiere decir que dentro del estado habra una propiedad llamada users y a esa propiedad
    //le asignaremos el valor de data que es lo que nos da todos los usuarios del backend
    this.userService.getAll().then(data => this.setState({users: data}))
  }

  //Al parecer siempre hay que implementar el metodo render
  render(){
    return (
      //Utilizaremos el componente datatable
      <DataTable value = {this.state.users}>
        <Column field="id" header="ID"></Column>
        <Column field="name" header="Name"></Column>
        <Column field="lastName" header="Last Name"></Column>
      </DataTable>
    );
  }

}

