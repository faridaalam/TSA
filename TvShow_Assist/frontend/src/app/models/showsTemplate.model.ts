export class showsTemplate {

    users : Users
    showName:string;

    constructor( users : Users,showName:string){

        this.users = users;
     
        this.showName = showName;
    }
}

export class Users {
    userId: number
    constructor( userId : number){
        this.userId = userId
    }

}