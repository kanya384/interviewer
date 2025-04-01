const { Marked } = globalThis.marked;
const { markedHighlight } = globalThis.markedHighlight;

const marked = new Marked(
  markedHighlight({
    emptyLangClass: 'hljs',
    langPrefix: 'hljs language-',
    highlight(code, lang, info) {
      const language = hljs.getLanguage(lang) ? lang : 'java';
      return hljs.highlight(code, { language }).value;
    }
  })
);