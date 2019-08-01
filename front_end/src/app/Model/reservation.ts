import { Register } from './register';
import { reserveRoom } from './reserveRoom';
import { building } from './building';

export class reservation{
    date:Date;
    startTime:Date;
    endTime:Date;
    event_name:String;
    event_type:String;
    info:String;
    register:Register;
    meetingRoom:reserveRoom;
    tower:building;
}