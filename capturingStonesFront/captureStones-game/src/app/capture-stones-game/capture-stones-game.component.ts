import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-capture-stones-game',
  templateUrl: './capture-stones-game.component.html',
  styleUrls: ['./capture-stones-game.component.css']
})
export class CaptureStonesGameComponent implements OnInit {

  board: number[] = [];


  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchGameStatus();
    this.fetchBoardValues();
  }

  fetchGameStatus() {
    this.http.get<string>(' http://localhost:8080/captureStones/game-status')
      .subscribe(status => {
        // Handle the game status, e.g., update your component state
        console.log('Game Status:', status);
      });
  }

    makeMove(pitIndex: number) {
      this.http.post('http://localhost:8080/captureStones/make-move', { playerNumber: 'ONE', smallPit: pitIndex })
        .subscribe(() => {
          // After making a move, you can fetch the updated game status
          this.fetchGameStatus();
        });
    }

  fetchBoardValues() {
    this.http.get<any>('http://localhost:8080/captureStones/board-values')
      .subscribe(data => {
        console.log(data.ONE); // Access the values for Player "ONE"
        console.log(data.TWO); // Access the values for Player "TWO"
        this.board = data.ONE.concat(data.TWO);

      });
  }

}
