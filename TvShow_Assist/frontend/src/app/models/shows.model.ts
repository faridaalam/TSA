export class Shows {
           
            url: string;
            name: string;
            
            language: string;
            status: string;
            runtime: number;
            premiered: string;
            officialSite: string;
            image: string;
            summary: string;


            constructor ( url:string, name:string, language:string, status:string, runtime:number, premiered:string, officialSite:string, image: string, summary: string) {
              
                this.url = url;
                this.name = name;
               
                this.language = language;
                this.status = status;
                this.runtime = runtime;
                this.premiered = premiered;
                this.officialSite = officialSite;
                this.image = image;
                this.summary = summary;
            }
}