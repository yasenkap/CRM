import { Client } from "./client.model";

export class Contact {
    id?: any;
    name?: string;
    surname?: string;
    email?: string;
    phoneNumber?: string;
    position?: string;
    client?: Client;
}
