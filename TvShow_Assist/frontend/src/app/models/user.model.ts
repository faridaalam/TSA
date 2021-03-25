export class User{
    id:number;
    name: string;
    lastName: string;
    password:string;
    email: string;
    city: string;

    constructor(id:number, name:string,lastName:string,password:string, email: string, city:string){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password =password;
        this.email = email;
        this.city = city;
    }
}