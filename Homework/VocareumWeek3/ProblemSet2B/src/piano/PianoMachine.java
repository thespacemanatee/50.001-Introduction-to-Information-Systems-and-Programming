package piano;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;

public class PianoMachine {
	
	private Midi midi;
	private Instrument instrument = Midi.DEFAULT_INSTRUMENT;
	private ArrayList<Integer> rawPitches = new ArrayList<>();
	private int octave = 0;
	private boolean isRecording = false;
	private ArrayList<NoteEvent> recording = new ArrayList<>();

    
	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(octave*Pitch.OCTAVE);
        if (!rawPitches.contains(rawPitch.hashCode())) {
            midi.beginNote(rawPitch.toMidiFrequency(), instrument);
            rawPitches.add(rawPitch.hashCode());
            if (isRecording) {
                long time = System.nanoTime()/10000000;
                NoteEvent note = new NoteEvent(rawPitch, time, instrument, NoteEvent.Kind.start);
                recording.add(note);
            }
        }
    }

    public void endNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(octave*Pitch.OCTAVE);
        if (rawPitches.contains(rawPitch.hashCode())) {
            midi.endNote(rawPitch.toMidiFrequency(), instrument);
            rawPitches.remove(Integer.valueOf(rawPitch.hashCode()));
            if (isRecording) {
                long time = System.nanoTime()/10000000;
                NoteEvent note = new NoteEvent(rawPitch, time, instrument, NoteEvent.Kind.stop);
                recording.add(note);
            }
        }
    }

    public void changeInstrument() {
        this.instrument = instrument.next();
    }

    public void shiftUp() {
        if (this.octave < 2) {
            this.octave++;
        }
    }

    public void shiftDown() {
        if (this.octave > -2) {
            this.octave--;
        }
    }

    public boolean toggleRecording() {
        if (!isRecording) {
            isRecording = true;
            recording.clear();
            return true;
        }
        isRecording = false;
        return false;
    }

    public void playback() {
        for (int i = 0; i < recording.size(); i++) {
            NoteEvent note = recording.get(i);
            if (note.getKind() == NoteEvent.Kind.start) {
                midi.beginNote(note.getPitch().toMidiFrequency(), note.getInstr());
            } else {
                midi.endNote(note.getPitch().toMidiFrequency(), note.getInstr());
            }
            if (i < recording.size() - 1) {
                NoteEvent nextNote = recording.get(i+1);
                int delay = (int) (nextNote.getTime() - note.getTime());
                Midi.rest(delay);
            }
        }
    }

}

class TestQ1Hw {


    private Midi midi;
    private PianoMachine pm;

    public void test() throws MidiUnavailableException, InterruptedException {
        midi = Midi.getInstance();
        midi.clearHistory();
        pm = new PianoMachine();

        pm.beginNote(new Pitch(0));
        Midi.rest(10);
        pm.endNote(new Pitch(0));

        pm.changeInstrument();
        Midi.rest(10);
        pm.changeInstrument();
        pm.beginNote(new Pitch(2));
        Midi.rest(10);
        pm.endNote(new Pitch(2));

        System.out.println(midi.history());
        midi.clearHistory();

        pm.shiftUp();
        pm.beginNote(new Pitch(2));
        Midi.rest(10);
        pm.endNote(new Pitch(2));
        pm.shiftDown();

        System.out.println(midi.history());
        midi.clearHistory();

        pm.toggleRecording();
        pm.beginNote(new Pitch(3));
        pm.beginNote(new Pitch(5));
        Midi.rest(10);
        pm.endNote(new Pitch(3));
        pm.endNote(new Pitch(5));
        pm.toggleRecording();

        System.out.println(midi.history());
        midi.clearHistory();
        Midi.rest(10);

        pm.playback();
        Midi.rest(10);

        System.out.println(midi.history());
        midi.clearHistory();

        pm.toggleRecording();
        pm.beginNote(new Pitch(4));
        pm.beginNote(new Pitch(6));
        Midi.rest(10);
        pm.endNote(new Pitch(4));
        pm.endNote(new Pitch(6));
        pm.toggleRecording();

        System.out.println(midi.history());
        midi.clearHistory();
        Midi.rest(10);

        pm.playback();
        Midi.rest(10);

        System.out.println(midi.history());


    }

    public static void main(String[] args) throws InterruptedException, MidiUnavailableException {
        new TestQ1Hw().test();
    }
}

