import { Client } from "./client.model";
import { Contact } from "./contact.model";

export class Vacancy {
    id?: any;
    title?: string;
    budget?: string;
    budgetType?: BudgetType;
    currency?: Currency;
    contractType?: ContractType;
    description?: string;
    contact?: Contact;
    client?: Client;
    status?: Status;
    skillTags?: string;
    
}

export enum Currency {
    PLN,
    GBP,
    USD
}

export enum BudgetType {
    HOUR = 'rate per hour',
    DAY = 'rate per day',
    MONTH = 'rate per month'
}

export enum ContractType {
    PERM,
    CONTRACTING
}

export enum Status {
    NOT_ACTIVE,
    BRIEFING_CALL,
    SEARCH,
    SCREENING,
    CVS_SENT,
    INTERVIEWS,
    OFFER,
    SIGNING
}


