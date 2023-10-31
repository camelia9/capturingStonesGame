import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-capture-stones-game',
  templateUrl: './capture-stones-game.component.html',
  styleUrls: ['./capture-stones-game.component.css']
})
export class CaptureStonesGameComponent implements OnInit {

  boardONE: number[] = [];
  boardTWO: number[] = [];
  status: string = ""
  player: string = ""
  isLast: number = 6 ;


  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchGameStatus();
    this.fetchBoardValues();
    this.fetchActivePlayer();
  }

  fetchGameStatus() {
    this.http.get<any>(' http://localhost:8080/captureStones/game-status')
      .subscribe(status => {
        this.status = status.status;
        console.log('Game Status:', status);
      });
  }

  fetchActivePlayer() {
    this.http.get<any>(' http://localhost:8080/captureStones/player-turn')
      .subscribe(player => {
        this.player = player.player;
        console.log('Active Player:', player);
      });
  }

    makeMove(pitIndex: number) {
      this.http.post('http://localhost:8080/captureStones/make-move', { playerNumber: this.player, smallPit: pitIndex })
        .subscribe(() => {
          this.fetchGameStatus();
        });
      setTimeout(() => {
        window.location.reload(); // Reload the page after the specified time so the board and stas will be reloaded
      }, 1 * 1000);
    }

  fetchBoardValues() {
    this.http.get<any>('http://localhost:8080/captureStones/board-values')
      .subscribe(data => {
        console.log(data.ONE);
        console.log(data.TWO);
        this.boardONE = data.ONE;
        this.boardTWO = data.TWO;
      });
  }

}
