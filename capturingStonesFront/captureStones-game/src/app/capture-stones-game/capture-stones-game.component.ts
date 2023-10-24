import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-capture-stones-game',
  templateUrl: './capture-stones-game.component.html',
  styleUrls: ['./capture-stones-game.component.css']
})
export class CaptureStonesGameComponent implements OnInit {

  board: number[] = [1,2,3];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchGameStatus();
  }

  fetchGameStatus() {
    // this.http.get<number[]>('/mancala/status')
    //   .subscribe(data => this.board = data);
  }

  makeMove(pitIndex: number) {
    // this.http.post('/mancala/move/' + pitIndex, null)
    //   .subscribe(() => this.fetchGameStatus());
  }

}
