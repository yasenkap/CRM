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
    PLN = "PLN",
    GBP = "GBP",
    USD = "USD"
}

export enum BudgetType {
    PER_HOUR = "PER_HOUR",
    PER_DAY = "PER_DAY",
    PER_MONTH = "PER_MONTH"
}

export enum ContractType {
    PERM = "PERM",
    CONTRACTING = "CONTRACTING"
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


