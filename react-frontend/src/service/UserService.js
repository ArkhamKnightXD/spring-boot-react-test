import axios from 'axios';

//Aqui creamos la clase UserService
export class UserService{

    baseUrl = "http://localhost:88/api/";

    //Aqui creamos un metodo que servira para obtener todos los usarios del backend
    //y retornalo de esta forma para que asi podamos utilizarlo en el frontend
    getAll(){
        
        return axios.get(this.baseUrl + "all").then(res => res.data);
    }

}