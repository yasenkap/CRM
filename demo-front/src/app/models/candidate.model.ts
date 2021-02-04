import { Vacancy } from "./vacancy.model";

export class Candidate {
    id?: any;
    name?: string;
    surname?: string;
    phoneNumber?: string;
    email?: string;
    skillSet?: string;
    description?: string;
    vacancies?: Vacancy[];
}
