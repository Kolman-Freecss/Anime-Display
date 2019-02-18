import { Gender } from '../../mocks/mock-gender';

export class Anime{
    id?: number;
    name: String;
    gender: Gender;
    isFinished?: boolean;

    constructor(
        name: String,
        gender: Gender,
        id?: number,
        isFinished?: boolean,
    ){
        id != null ? this.id = id : "";
        this.name = name;
        this.gender = gender;
        isFinished != null ? this.isFinished = isFinished : "";
    }

    setId?(id: number): void{
        this.id = id;
    }
}