import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaptureStonesGameComponent } from './capture-stones-game.component';

describe('CaptureStonesGameComponent', () => {
  let component: CaptureStonesGameComponent;
  let fixture: ComponentFixture<CaptureStonesGameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaptureStonesGameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CaptureStonesGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
